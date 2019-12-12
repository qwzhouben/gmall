package com.zben.gmall.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.UUID;

/**
 * @DESC: redis工具类
 * @author: zhouben
 * @date: 2019/12/11 0011 18:33
 */
public class RedisUtil {

    private static final String KEY = "redis:lock:";

    private JedisPool jedisPool;

    public void initPool(String host, int port, int database) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(200);
        config.setMaxIdle(30);
        config.setBlockWhenExhausted(true);
        config.setMaxWaitMillis(10*1000);
        config.setTestOnBorrow(true);
        jedisPool=new JedisPool(config,host,port,20*1000);
    }

    public Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 获取分布式锁
     * @param acquireTimeout 获取锁之前的超时时间
     * @param timeout        获取锁之后的有效期
     * @return
     */
    public String getRedisLock(Jedis jedis, Long acquireTimeout, Long timeout, String key) {
        try {
            if (jedis == null) {
                System.out.println("getRedisLock没有建立redis连接");
                return null;
            }
            Long endTime = System.currentTimeMillis() + acquireTimeout;
            String value = UUID.randomUUID().toString();
            while (System.currentTimeMillis() < endTime) {
                if (jedis.setnx(KEY+key, value) == 1) {
                    jedis.expire(KEY+key, (int) (timeout / 1000));
                    return value;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    /**
     * 释放锁 保证删除的是自己的
     * @param value
     */
    public void redisUnlock(Jedis jedis, String key, String value) {
        try {
            if (jedis == null) {
                System.out.println("redisUnlock没有建立redis连接");
                return;
            }
            if (value.equals(jedis.get(KEY+key))) {
                //redis支持lua， jedis.eval("lua") ，用lua脚本 获取到值就删掉， 防止高并发出现问题
                jedis.del(KEY+key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}

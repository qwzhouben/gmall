package com.zben.gmall.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 基础销售属性
 */
@Data
public class PmsBaseSaleAttr implements Serializable {

    @Id
    @Column
    String id ;

    @Column
    String name;

}
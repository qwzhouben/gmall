package com.zben.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2019/12/4 0004 11:30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GmallManageTestApplication {

    @Test
    public void fileupload() throws IOException, MyException {
        String file = ClassLoader.getSystemClassLoader().getResource("tracker.conf").getFile();
        ClientGlobal.init(file);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        String orginalFileName = "C:\\Users\\Administrator\\Desktop\\O1CN01cWbmXU1X6KnJF0BJ5_!!197232874.jpg";
        String[] uploadFile = storageClient.upload_file(orginalFileName, "jpg", null);
        for (int i = 0; i < uploadFile.length; i++) {
            String s = uploadFile[i];
            System.out.println("s = " + s);
        }
    }
}

























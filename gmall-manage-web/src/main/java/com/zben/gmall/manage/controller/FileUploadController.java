package com.zben.gmall.manage.controller;

import com.zben.gmall.manage.util.PmsUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @DESC: 文件上传
 * @author: zhouben
 * @date: 2019/12/4 0004 11:45
 */
@Controller
@CrossOrigin
public class FileUploadController {

    /**
     * 上传图片
     */
    @PostMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) {
        //上传到服务器
        return PmsUploadUtil.uploadImage(multipartFile);
    }
}

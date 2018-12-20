package com.hanslaser.blog.controller;

import com.hanslaser.blog.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 图片上传下载接口
 *
 * @author LuoJu
 * @since 2018.12.19
 */
@RequestMapping("/image")
@Controller
public class ImageController {

    @Autowired
    private AttachmentService attachmentService;

    @PostMapping("/loadImage")
    @ResponseBody
    public Map updateMaterial(@RequestParam("upload") MultipartFile file, HttpServletRequest request) {
        Map<String, String> map = attachmentService.ckEditorUploadImage(file, request);
        return map;
    }

}
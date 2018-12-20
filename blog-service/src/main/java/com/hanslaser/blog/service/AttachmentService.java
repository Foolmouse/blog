package com.hanslaser.blog.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 文件处理(图片/视频)
 *
 * @author LuoJu
 * @since 2018.12.20
 */
public interface AttachmentService {

    Map<String, String> ckEditorUploadImage(MultipartFile file, HttpServletRequest request);
}

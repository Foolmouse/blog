package com.hanslaser.blog.service.impl;

import com.hanslaser.blog.service.AttachmentService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LuoJu
 * @since 2018.12.20
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {

    private static final String WINDOWS_UPLOAD_PATH = "E:\\uploadImages";
    private static final String LINUX_UPLOAD_PATH = "/home/uploadImages";
    //对应tomcat配置中的虚拟路径
    private static final String VIRTUAL_PATH = "/uploadImages";

    @Override
    public Map<String, String> ckEditorUploadImage(MultipartFile file, HttpServletRequest request) {
        if (file == null || "".equals(file.getOriginalFilename().trim())) {
            return generateResult(false, "#");
        }
        String originalName = file.getOriginalFilename();
        // generate file name
        String localFileName = System.currentTimeMillis() + "-" + originalName;
        // get project path
        // 这里不适用项目路径,使用配置的虚拟路径
        String projectRealPath = request.getSession().getServletContext().getRealPath("");
        String realPath = isWhichSystem();
        File imageDir = new File(realPath);
        if (!imageDir.exists()) {
            imageDir.mkdirs();
        }

        String localFilePath = realPath + File.separator + localFileName;
        try {
            file.transferTo(new File(localFilePath));
        } catch (IllegalStateException e) {
            e.printStackTrace();
            // log here
        } catch (IOException e) {
            e.printStackTrace();
            // log here
        }
        String imageContextPath = request.getContextPath() + VIRTUAL_PATH + "/" + localFileName;
        // log here +
        System.out.println("received file original name: " + originalName);
        System.out.println("stored local file name: " + localFileName);
        System.out.println("file stored path: " + localFilePath);
        System.out.println("returned url: " + imageContextPath);
        // log here -
        return generateResult(true, imageContextPath);
    }

    private Map<String, String> generateResult(boolean uploaded, String relativeUrl) {
        Map<String, String> result = new HashMap<String, String>();
        result.put("uploaded", uploaded + "");
        result.put("url", relativeUrl);

        return result;
    }

    private String isWhichSystem() {
        String osName = System.getProperties().getProperty("os.name");
        if (osName.equals("Linux")) {
            System.out.println(">>>>>>>>>>>>>>>>>>running in Linux>>>>>>>>>>>>>>>>>>");
            return LINUX_UPLOAD_PATH;
        } else {
            System.out.println(">>>>>>>>>>>>>>>>>>don't running in Linux>>>>>>>>>>>>>>>>>>");
            return WINDOWS_UPLOAD_PATH;
        }
    }

}

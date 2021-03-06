package com.hanslaser.blog.service.impl;

import com.hanslaser.blog.service.AttachmentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * desc: save images
 *
 * @author LuoJu
 * @since 2018.12.20
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Value("${upload.file.windows.path:#{null}}")
    private String WINDOWS_UPLOAD_PATH;
    @Value("${upload.file.linux.path:#{null}}")
    private String LINUX_UPLOAD_PATH;
    //对应tomcat配置中的虚拟路径
    public static final String VIRTUAL_PATH = "/uploadImages";

    @Override
    public Map<String, String> ckEditorUploadImage(MultipartFile file, HttpServletRequest request) {
        if (file == null || "".equals(file.getOriginalFilename().trim())) {
            return generateResult(false, "#");
        }
        String originalName = file.getOriginalFilename();
        // generate file name
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMhh");
        //String localFileName = format.format(new Date()) + "-" + System.currentTimeMillis() + "-" + originalName;

        Calendar instance = Calendar.getInstance();
        String currentData = "" + instance.get(Calendar.YEAR) + instance.get(Calendar.MONDAY) + instance.get(Calendar.DAY_OF_MONTH);
        String localFileName = currentData + "-" + System.currentTimeMillis() + "-" + originalName;

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

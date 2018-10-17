package com.flf.entity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class FileUtil {

    public static Map<String, String> uploadImg(MultipartFile file, HttpServletRequest req) {
        String path = "D:\\Subversion\\ssm\\WebRoot\\uploadFiles\\uploadImgs";
        String fileName = file.getOriginalFilename();
        fileName = UUID.randomUUID() + "_" + fileName;
        File newFile = new File(path, fileName);
        if (!newFile.exists()) {
            newFile.mkdirs();
        }
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("fileUrl", fileName);
        return map;
    }

    public static Map<String, String> uploadFile(MultipartFile file, HttpServletRequest req) {
        String path = "D:\\Subversion\\ssm\\WebRoot\\uploadFiles\\uploadFile";
        String fileName = file.getOriginalFilename();
        fileName = UUID.randomUUID() + "_" + fileName;
        File newFile = new File(path, fileName);
        if (!newFile.exists()) {
            newFile.mkdirs();
        }
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("fileUrl", fileName);
        return map;
    }
}

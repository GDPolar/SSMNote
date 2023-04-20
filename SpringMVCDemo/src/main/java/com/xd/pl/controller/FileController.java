package com.xd.pl.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
public class FileController {

    @RequestMapping("testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        // 套路
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("img");
        realPath = realPath + File.separator + "111.jpg";
        InputStream is = Files.newInputStream(Paths.get(realPath));
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        MultiValueMap<String, String> httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment;filename=111.jpg");
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, httpHeaders, statusCode);
        is.close();
        return responseEntity;
    }

    @RequestMapping("testUpload")
    // 在配置文件中配置文件上传解析器，配置依赖
    // MultipartFile photo 接收上传的文件，参数名和文件的 name 属性对应一致
    public String testUpload(MultipartFile photo, HttpSession session) throws IOException {
        String filename = photo.getOriginalFilename();
        String postFix = filename.substring(filename.lastIndexOf("."));
        filename = UUID.randomUUID() + postFix;
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        File file = new File(photoPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + filename;
        // 通过 transferTo() 上传到指定位置
        photo.transferTo(new File(finalPath));
        return "hello";
    }

    // 测试异常处理
    @RequestMapping("testException")
    public String testException() {
        System.out.println(1 / 0);
        return "success";
    }
}

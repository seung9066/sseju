package com.sseju.java.eqm.service;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;

public class FileUtil {

   //파일 다운로드
   public static void fileDownload (String fname, HttpServletRequest request, HttpServletResponse response) throws Exception {

   
     File file = new File(fname);
     BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
     //형식을 모르는 파일첨부용 contentType
     response.setContentType("application/octet-stream");
     //다운로드와 다운로드될 파일이름
     response.setHeader("Content-Disposition", "attachment; filename=\"1\"");
     //파일복사
     FileCopyUtils.copy(in, response.getOutputStream());
     in.close();
     response.getOutputStream().flush();
     response.getOutputStream().close();
   }
}
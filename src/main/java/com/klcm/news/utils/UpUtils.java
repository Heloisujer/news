package com.klcm.news.utils;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件图片上传类
 * @author 王雨婷
 *
 */
public class UpUtils {
	public static String upfile(MultipartFile file,HttpServletRequest request) {
		//获取我们的项目在tomcat上路径
		String realPath = request.getSession().getServletContext().getRealPath("/");
		System.out.println(realPath);
		String basePath = "D:\\千峰实训\\workspace\\news\\src\\main\\webapp\\";
		//设置文件上传后的保存路径
		String savePath="images/upFile/";
		File file1=new File(realPath+savePath);
		//判断路径是否存在，若不存在，则创建目录
		if (!file1.exists()) {
			file1.mkdirs();
		}
		
		File file2=new File(basePath+savePath);
		if (!file2.exists()) {
			file2.mkdirs();
		}
		
		//获取上传文件的名字
		String orgName=file.getOriginalFilename(); //1.jpg
		String end = orgName.substring(orgName.lastIndexOf("."));
		String begin = String.valueOf(System.currentTimeMillis());		
		String imgPath = savePath + begin+end;
		try {
			FileOutputStream fos = new FileOutputStream(realPath+imgPath,true);
			FileOutputStream fos1 = new FileOutputStream(basePath+imgPath,true);
			fos.write(file.getBytes());
			fos1.write(file.getBytes());
			fos1.flush();
			fos.flush();
			fos1.close();
			fos.close();
			return imgPath;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}		
	}
}

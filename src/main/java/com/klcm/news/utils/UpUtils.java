package com.klcm.news.utils;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * �ļ�ͼƬ�ϴ���
 * @author ������
 *
 */
public class UpUtils {
	public static String upfile(MultipartFile file,HttpServletRequest request) {
		//��ȡ���ǵ���Ŀ��tomcat��·��
		String realPath = request.getSession().getServletContext().getRealPath("/");
		System.out.println(realPath);
		String basePath = "D:\\ǧ��ʵѵ\\workspace\\news\\src\\main\\webapp\\";
		//�����ļ��ϴ���ı���·��
		String savePath="images/upFile/";
		File file1=new File(realPath+savePath);
		//�ж�·���Ƿ���ڣ��������ڣ��򴴽�Ŀ¼
		if (!file1.exists()) {
			file1.mkdirs();
		}
		
		File file2=new File(basePath+savePath);
		if (!file2.exists()) {
			file2.mkdirs();
		}
		
		//��ȡ�ϴ��ļ�������
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

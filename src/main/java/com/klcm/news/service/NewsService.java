package com.klcm.news.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.klcm.news.pojo.Message;
import com.klcm.news.pojo.News;

/**
 * 新闻信息服务层接口
 * @author 王雨婷
 *
 */
public interface NewsService {

	List<News> findAll();

	List<News> findByLike(String title);

	Message addNews(News news, String type, MultipartFile file, HttpServletRequest request);

	Message updateNews(News news, String type, MultipartFile file, HttpServletRequest request);

	Message deleteById(String nId);

}

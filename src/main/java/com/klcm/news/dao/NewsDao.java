package com.klcm.news.dao;

import java.util.List;
import com.klcm.news.pojo.News;

/**
 * 新闻信息数据层接口
 * @author 王雨婷
 *
 */
public interface NewsDao {
	
	List<News> findBykId(String kId);

	List<News> findAll();

	List<News> findByLike(String title);

	News findByTitle(String title);

	void addNews(News news);

	News findById(String id);

	void updateNews(News news);

	void deleteById(News news);

	

	

}

package com.klcm.news.dao;

import java.util.List;
import com.klcm.news.pojo.News;

/**
 * ������Ϣ���ݲ�ӿ�
 * @author ������
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

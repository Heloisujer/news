package com.klcm.news.dao.impl;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.klcm.news.dao.NewsDao;
import com.klcm.news.pojo.News;

/**
 * 新闻信息数据层
 * @author 王雨婷
 *
 */
@Repository
public class NewsDaoImpl implements NewsDao{
	
	@Resource
	private SessionFactory sessionFactory;
	
	public List<News> findBykId(String kId) {
		// TODO Auto-generated method stub
		String hql="from News n where n.kind.id =:kId";
		return sessionFactory.getCurrentSession().createQuery(hql,News.class).setParameter("kId", kId).getResultList();
	}

	public List<News> findAll() {
		// TODO Auto-generated method stub
		String hql="from News n order by n.id";
		return sessionFactory.getCurrentSession().createQuery(hql,News.class).getResultList();
	       }

	public List<News> findByLike(String title) {
		// TODO Auto-generated method stub
		String hql="from News n where n.title like :title";
		return sessionFactory.getCurrentSession().createQuery(hql,News.class).setParameter("title", "%"+title+"%").getResultList();
	}

	public News findByTitle(String title) {
		// TODO Auto-generated method stub
		String hql="from News n where n.title=:title";
		return sessionFactory.getCurrentSession().createQuery(hql,News.class).setParameter("title",title).uniqueResult();
	}

	public void addNews(News news) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(news);
	}

	public News findById(String id) {
		// TODO Auto-generated method stub
		String hql ="from News n where n.id=:id";
		return sessionFactory.getCurrentSession().createQuery(hql,News.class).setParameter("id",id).uniqueResult();
	}

	public void updateNews(News news) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().merge(news);
	}

	public void deleteById(News news) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(news);
	}

	

	
	

}

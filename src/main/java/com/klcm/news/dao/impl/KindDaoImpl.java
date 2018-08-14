package com.klcm.news.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import com.klcm.news.dao.KindDao;
import com.klcm.news.dao.NewsDao;
import com.klcm.news.pojo.Kind;

/**
 * 新闻分类数据层
 * @author 王雨婷
 *
 */
@Repository
public class KindDaoImpl implements KindDao{
       
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private NewsDao newsDao;

	public List<Kind> findAll() {
		// TODO Auto-generated method stub
		String hql="from Kind k order by k.id";
		List<Kind> kinds = sessionFactory.getCurrentSession().createQuery(hql,Kind.class).getResultList();
		return kinds;
	}

	public Kind findByType(String type) {
		// TODO Auto-generated method stub
		String hql="from Kind k where k.type=:type";
		Kind kind = sessionFactory.getCurrentSession().createQuery(hql,Kind.class).setParameter("type", type).uniqueResult();		
		return kind;
	}

	public void addKind(Kind kind) {
		// TODO Auto-generated method stub		
		sessionFactory.getCurrentSession().persist(kind);
	}
	
	

	public void updateKind(Kind kind) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().merge(kind);
	}

	public Kind finById(String kId) {
		// TODO Auto-generated method stub
		String hql="from Kind k where k.id=:kId";
		return sessionFactory.getCurrentSession().createQuery(hql,Kind.class).setParameter("kId", kId).uniqueResult();
		
	}

	public void deleteById(Kind kind) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(kind);
	}

	
}


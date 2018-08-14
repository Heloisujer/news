package com.klcm.news.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.klcm.news.dao.UserDao;
import com.klcm.news.pojo.User;

/**
 * 用户数据层
 * @author 王雨婷
 *
 */
@Repository
public class UserDaoImpl implements UserDao{
	@Resource
	private SessionFactory sessionFactory;

	public User findByName(String uName) {
		// TODO Auto-generated method stub
		String hql="from User u where u.uName =:uName";
		return sessionFactory.getCurrentSession().createQuery(hql,User.class).setParameter("uName",uName).uniqueResult();
		
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		String hql = "from User u order by u.id";
		return sessionFactory.getCurrentSession().createQuery(hql,User.class).getResultList();
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(user);
	}

	public User findById(String uId) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.id=:uId";
		return sessionFactory.getCurrentSession().createQuery(hql,User.class).setParameter("uId", uId).uniqueResult();
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().merge(user);
	}

	
}

package com.klcm.news.dao;

import java.util.List;

import com.klcm.news.pojo.User;

/**
 * 用户数据层接口
 * @author 王雨婷
 *
 */
public interface UserDao {

	User findByName(String getuName);

	List<User> findAll();

	void addUser(User user);

	User findById(String uId);

	void deleteUser(User user);

	void updateUser(User user);



}

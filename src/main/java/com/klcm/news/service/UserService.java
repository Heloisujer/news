package com.klcm.news.service;

import java.util.List;

import com.klcm.news.pojo.Message;
import com.klcm.news.pojo.User;

/**
 * �û������ӿ�
 * @author ������
 *
 */
public interface UserService {

	Message login(User user);

	List<User> findAll();

	Message addUser(User user);

	Message deleteUser(String uId);

	Message updateUser(User user);

	Message updatePwd(User currentUser, String nPwd);

	User findByName(String uName);


}


package com.linjie.service;

import com.linjie.dao.UserDao;
import com.linjie.entity.User;

public class UserService {

	private UserDao userDao = new UserDao();
	/*
	 * 添加用户，进行注册
	 */
	public void addUser(User user) throws Exception {
		
		// 调用dao层的添加用户方法
		
		userDao.addUser(user);
	}

	/*
	 * 查找用户，进行登录
	 */
	public User findUser(String username, String password) throws Exception {
		
		// 调用dao层的查找用户方法
		User user = userDao.findUser(username, password);
		return user;
	}
	
}

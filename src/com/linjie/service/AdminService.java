package com.linjie.service;

import com.linjie.dao.AdminDao;
import com.linjie.entity.Admin;

public class AdminService {

	/*
	 * 查找管理员信息，进行登录
	 */
	public Admin findAdmin(String username, String password) throws Exception {
		
		// 调用dao层findAdmin方法连接数据库进行查询
		AdminDao adminDao = new AdminDao();
		Admin admin = adminDao.findAdmin(username, password);
		
		if(admin != null) {
			return admin;
		}else {
			throw new Exception("用户名或密码错误");
		}  
	}

}

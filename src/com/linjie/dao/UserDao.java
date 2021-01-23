package com.linjie.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.linjie.entity.User;
import com.linjie.util.JdbcUtil;

public class UserDao {

	private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
	
	/*
	 * 添加用户，进行注册
	 */
	public void addUser(User user) throws Exception {
		
		String sql = "insert into t_user(cid,username,password,phone) value(?,?,?,?)";
		queryRunner.update(sql,user.getUid(),user.getUsername(),user.getPassword(),user.getPhone());
		
	}

	/*
	 * 查找用户，进行登录
	 */
	public User findUser(String username, String password) throws Exception {
		
		String sql = "select * from t_user where username=? and password=?";
		return queryRunner.query(sql, new BeanHandler<User>(User.class), username, password);
	}

}

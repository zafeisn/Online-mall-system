package com.linjie.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.linjie.entity.Admin;
import com.linjie.util.JdbcUtil;

public class AdminDao {

	private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
	/*
	 * 连接数据库查找管理员信息，进行登录
	 */
	public Admin findAdmin(String username, String password) throws Exception {
		
		String sql = "select * from t_admin where username=? and password=?";
		return queryRunner.query(sql, new BeanHandler<Admin>(Admin.class), username, password);
	}

}

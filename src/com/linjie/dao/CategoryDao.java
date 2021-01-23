package com.linjie.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.linjie.entity.Category;
import com.linjie.util.JdbcUtil;

public class CategoryDao {

	/*
	 * 查找全部商品分类
	 */
	public List<Category> findAllCategory() throws Exception {
		
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from t_category";
		List<Category> allCategory = queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
		return allCategory;
	}

}

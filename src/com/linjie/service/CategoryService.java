package com.linjie.service;

import java.util.List;

import com.linjie.dao.CategoryDao;
import com.linjie.entity.Category;

public class CategoryService {
	
	/*
	 * 查找全部商品分类
	 */
	public List<Category> findAllCategory() throws Exception {
		
		// 调用dao层，连接数据库，查找全部商品分类
		CategoryDao categoryDao = new CategoryDao();
		return categoryDao.findAllCategory();
	}
}

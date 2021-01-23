package com.linjie.service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.linjie.dao.GoodsDao;
import com.linjie.entity.Goods;
import com.linjie.entity.PageBean;

public class GoodsService {

	private GoodsDao goodsDao = new GoodsDao();
	
	/*
	 * 查找全部商品信息
	 */
	public List<Goods> findAllGoods() throws Exception {
		
		// 调用dao层的findAllGoods方法，获取查找结果
		
		return goodsDao.findAllGoods();
	}

	/*
	 * 添加商品，写入到数据库中
	 */
	public void addGoods(Goods goods) throws Exception {
		
		// 调用dao层，addGoods方法
		goodsDao.addGoods(goods);
	}

	/*
	 * 根据id实现商品删除
	 */
	public void delGoods(int id) throws Exception {
		
		// 调用dao层，delGoods方法实现删除
		goodsDao.delGoods(id);
	}

	/*
	 * 根据id查找商品信息
	 */
	public Goods findGoodsWithId(int id) throws Exception {
		
		// 调用dao层，findGoodsWithId方法实现数据库的商品信息更新
		return goodsDao.findGoodsWithId(id);
	}

	/*
	 * 更新商品信息
	 */
	public void updateGoods(Goods goods) throws Exception {
		
		// 调用dao层，实现商品的数据库更新
		goodsDao.updateGoods(goods);
	}

	/*
	 * 获取PageBean
	 * 1、设置当前页
	 * 2、设置一页显示的商品数
	 * 3、获取并设置总记录数
	 * 4、计算并设置总页数
	 * 5、获取并设置当前页的商品
	 */
	public PageBean getPageBean(Integer currentPage) throws Exception {
		
		PageBean pageBean = new PageBean();
		// 设置当前页
		pageBean.setCurrentPage(currentPage);
		// 获取总记录数
		Long count = goodsDao.getGoodsCount();
		// 设置总记录数
		pageBean.setTotalCount(count.intValue());
		// 设置一页显示的商品数
		Integer pageCount = 5;
		// 计算总页数
		double totalPage = Math.ceil(1.0 * pageBean.getTotalCount() / pageCount);
		// 设置总页数
		pageBean.setTotalPage((int)totalPage);
		
		//设置当前页的商品角标
		Integer index = (pageBean.getCurrentPage() - 1) * pageCount;
		// 获取当前页的商品
		List<Goods> list = goodsDao.getPageData(index, pageCount);
		// 设置当前页显示的商品
		pageBean.setListGoods(list);
		
		return pageBean;
	}


}

package com.linjie.dao;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.linjie.entity.Goods;
import com.linjie.util.JdbcUtil;

public class GoodsDao {

	private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
	
	/*
	 * 连接数据库进行查询商品，在页面中显示 
	 */
	public List<Goods> findAllGoods() throws Exception {
		
		String sql = "select * from t_goods";
		List<Goods> list = queryRunner.query(sql, new BeanListHandler<Goods>(Goods.class));
		return list;
	}

	/*
	 * 添加商品到数据库中
	 */
	public void addGoods(Goods goods) throws Exception {
		
		String sql = "insert into t_goods(gid,gname,gprice,gimage,gdesc,gis_hot,cid) value(?,?,?,?,?,?,?)";
		queryRunner.update(sql, goods.getGid(), goods.getGname(), goods.getGprice(), goods.getGimage(),goods.getGdesc(),
				goods.getGis_hot(), goods.getCid());
		
	}

	/*
	 * 根据id删除商品
	 */
	public void delGoods(int id) throws Exception {
		
		String sql = "delete from t_goods where gid=?";
		queryRunner.update(sql, id);
	}

	/*
	 * 根据id查找商品信息
	 */
	public Goods findGoodsWithId(int id) throws Exception {
		
		String sql = "select * from t_goods where gid=?";
		Goods goods = queryRunner.query(sql, new BeanHandler<Goods>(Goods.class), id);
		return goods;
	}

	/*
	 * 更新商品信息
	 */
	public void updateGoods(Goods goods) throws Exception {
		
		String sql = "update t_goods set gname=?, gprice=?, gimage=?, gdesc=?, gis_hot=?, cid=? where gid=?";
		int update = queryRunner.update(sql, goods.getGname(), goods.getGprice(), goods.getGimage(), goods.getGdesc(),
				goods.getGis_hot(), goods.getCid(), goods.getGid());
		
		if(update == 1) {
			System.out.println("更新成功：" + goods);
		}
	}

	/*
	 * 获取商品总个数
	 */
	public Long getGoodsCount() throws Exception {
		
		String sql = "select count(*) from t_goods";
		Long count = (Long)queryRunner.query(sql, new ScalarHandler());
		return count;
	}

	/*
	 * 根据角标和一页显示的商品数进行条件查询，分页显示商品
	 */
	public List<Goods> getPageData(Integer index, Integer pageCount) throws Exception {

		String sql = "select * from t_goods limit ?,?";
		List<Goods> listGoods = queryRunner.query(sql, new BeanListHandler<Goods>(Goods.class), index, pageCount);
		
		// 反转
		Collections.reverse(listGoods);
		return listGoods;
		
	}

}

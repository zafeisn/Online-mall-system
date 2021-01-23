package com.linjie.web;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.linjie.entity.Category;
import com.linjie.entity.Goods;
import com.linjie.entity.PageBean;
import com.linjie.service.CategoryService;
import com.linjie.service.GoodsService;
/**
 * 商品管理
 */
@WebServlet("/GoodsServlet")
public class GoodsServlet extends BaseServlet {
	
	/*
	 * 根据页码来显示商品数，需要根据PageBean来确定
	 */
	public String getPageBean(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		
		// 接收当前页码参数
		String currentPage = request.getParameter("currentPage");
		// 调用service层，getPageBean方法来获取PageBean
		GoodsService goodsService = new GoodsService();
		try {
			PageBean pageBean = goodsService.getPageBean(Integer.parseInt(currentPage));
			//Collections.reverse(pageBean.getListGoods());
			// 存入request请求域中
			request.setAttribute("pageBean", pageBean);
			
			// 转发
			return "admin/main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	 * 查询全部商品，并显示在main列表中
	 */
	public String listServlet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		
		// 调用service层，findAllGoods方法
		GoodsService goodsService = new GoodsService();
		try {
			List<Goods> allGoods = goodsService.findAllGoods();
			// 对商品进行反转
			Collections.reverse(allGoods);
			// 存入request请求域中
			request.setAttribute("allGoods", allGoods);
			
			// 转发
			System.out.println(allGoods);
			return "admin/main.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 新增商品获取全部分类页面
	 */
	public String addUIServlet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		// 调用service层，findAllCategory方法获取全部分类信息
		CategoryService categoryService = new CategoryService();
		try {
			List<Category> allCategory = categoryService.findAllCategory();
			// 存入request请求域中
			request.setAttribute("allCategory", allCategory);
			
			// 发送给add.jsp新增商品
			System.out.println(allCategory);
			return "admin/add.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 新增商品
	 */
	public String addServlet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		// 接收从add.jsp表单中提交的商品信息
		Map<String, String[]> parameterMap = request.getParameterMap();
		Goods goods = new Goods();
		try {
			// 封装成goods对象
			BeanUtils.populate(goods, parameterMap);
			
			// 调用service层，addGoods方法添加商品到数据库中
			GoodsService goodsService = new GoodsService();
			goodsService.addGoods(goods);
			
			// 返回到商品列表查询
			System.out.println("获取的商品：" + goods);
			return "/GoodsServlet?action=getPageBean&currentPage=1";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 删除商品，根据商品id实现删除
	 */
	public String delServlet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//接收商品id
		String id = request.getParameter("id");
		// 调用service层，delGoods方法实现商品删除
		GoodsService goodsService = new GoodsService();
		try {
			goodsService.delGoods(Integer.parseInt(id));
			
			System.out.println("该商品已删除");
			return "GoodsServlet?action=getPageBean&currentPage=1";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 编辑商品详情页，根据id获取商品信息
	 */
	public String editUIServlet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 接收商品id
		String id = request.getParameter("id");
		String currentPage = request.getParameter("currentPage");
		
		try {
			// 调用service层，根据id获取goods商品信息，并存入请求域中
			GoodsService goodsService = new GoodsService();
			Goods goods = goodsService.findGoodsWithId(Integer.parseInt(id));
			request.setAttribute("goods", goods);
			
			// 调用service层，获取全部商品分类，并存入请求域中
			CategoryService categoryService = new CategoryService();
			List<Category> allCategory = categoryService.findAllCategory();
			request.setAttribute("allCategory", allCategory);
			
			// 将当前页存入请求域中
			request.setAttribute("currentPage", currentPage);
			
			// 跳转到编辑页面
			System.out.println("跳转到编辑页面");
			return "admin/edit.jsp";
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/*
	 * 编辑商品，同步到数据库中，并跳转到商品列表页面
	 */
	public String editServlet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String currentPage = request.getParameter("currentPage");
		// 接收商品参数信息
		Map<String, String[]> parameterMap = request.getParameterMap();
		
		try {
			Goods goods = new Goods();
			// 封装成goods对象
			BeanUtils.populate(goods, parameterMap);
			
			// 调用service层，updateGoods方法实现更新
			GoodsService goodsService = new GoodsService();
			goodsService.updateGoods(goods);
			
			// 跳转到商品列表页面
			return "/GoodsServlet?action=getPageBean&currentPage="+currentPage;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

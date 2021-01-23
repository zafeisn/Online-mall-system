package com.linjie.web;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.linjie.entity.User;
import com.linjie.service.UserService;

/**
 * 用户操作功能
 * 1、注册
 * registServlet
 * 注册成功进行跳转登录
 * 
 * 2、登录
 * loginServlet
 * 登录成功进行跳转首页
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	
	/*
	 * 用户注册
	 * 根据验证码填写是否正确，再进行下一步注册操作
	 */
	public String registServlet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		// 设置字符集格式
		request.setCharacterEncoding("UTF-8");
		
		// 从表单接收用户验证码填写
		String code = request.getParameter("code");
		// 获取正确的验证码
		String word = (String)this.getServletContext().getAttribute("checkCode");
		
		// 判断验证码是否正确
		if(word.equals(code)) {
			/*
			 * 输入的验证码正确，连接数据库，写入到数据库当中进行保存，并跳转到登录页面
			 * 采用MVC三层框架
			 */
			// 从表单中获取用户所有信息
			Map<String, String[]> parameterMap = request.getParameterMap();
			User user = new User();
			try {
				// 封装成user对象
				BeanUtils.populate(user, parameterMap);
				// 设置用户id
				user.setUid(UUID.randomUUID().toString());
				
				// 调用service层，addUser添加用户方法
				UserService userService = new UserService();
				userService.addUser(user);
				
				System.out.println("注册成功");
				return "/login.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("验证码错误");
			return "/regist.jsp";
		}
		return null;
	}
	
	/*
	 * 用户登录
	 * 连接数据库，验证用户信息是否正确，若正确则进行跳转到首页显示
	 */
	public String loginServlet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		// 设置字符集格式
		request.setCharacterEncoding("UTF-8");
		
		// 接收用户登录表单参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 调用service层，findUser方法
		UserService userService = new UserService();
		User user = null;
		try {
			user = userService.findUser(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 判断用户信息是否为空
		if(user != null) {
			
			// 将用户信息发送到session域中
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			System.out.println("登录成功");
			return "/index.jsp";
			
		}else {
			// 为空，提示用户名或者密码不正确，并跳转登录页面重新登录
			System.out.println("用户名或密码错误");
			return "/login.jsp";
		}
	}
	
	/*
	 * 用户登出
	 * 销毁session会话对象，跳转到当前首页
	 */
	public String logoutServlet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		
		// 获取session，若session为空，则返回null
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		System.out.println("已成功退出");
		return "/index.jsp";
	}
	
}

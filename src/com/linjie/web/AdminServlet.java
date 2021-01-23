package com.linjie.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.linjie.entity.Admin;
import com.linjie.service.AdminService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends BaseServlet {
	
	public String loginServlet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		// 设置字符集编码格式
		request.setCharacterEncoding("UTF-8");
		
		// 接收管理员登录信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			// 连接数据库进行验证，调用service层findAdmin方法
			AdminService adminService = new AdminService();
			Admin admin = adminService.findAdmin(username, password);
			
			// 存入session域中
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			
			// 验证成功则跳转到admin_index.jsp
			System.out.println("管理员：" + username + " 登录成功");
			
			return "/admin/admin_index.jsp";
		} catch (Exception e) {
			if(e.getMessage().equals("用户名或密码错误")) {
				// 存入request请求域中
				request.setAttribute("error", e.getMessage());
				return "/admin/admin_login.jsp";
			}else {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}

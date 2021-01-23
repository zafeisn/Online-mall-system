package com.linjie.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 从浏览器上接收action方法地址，判断该方法是否存在servlet中
 * 若方法存在，则进行执行获取返回地址，返回地址不为空则进行跳转
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 设置字符集格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 1、获取浏览器发送的action方法参数
		String action = request.getParameter("action");
		// 2、接收字节码文件
		Class clazz = this.getClass();
		try {
			// 3、获取字节码中的方法
			Method method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
			// 4、判断是否有该方法
			if(method != null) {
				// 5、执行同名方法，获取返回地址
				String rePath = (String)method.invoke(this, request, response);
				if(rePath != null) {
					// 6、判断返回地址是否为空，不为空则进行转发
					request.getRequestDispatcher(rePath).forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

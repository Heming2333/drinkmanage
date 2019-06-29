package com.demos.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demos.entity.User;
import com.demos.service.UserService;
import com.demos.service.impl.UserServiceImpl;

public class DoLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收数据
		String name = request.getParameter("name");
		String password= request.getParameter("password");
		
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		
		// 调用业务逻辑方法完成数据处理
		UserService userService = new UserServiceImpl();
		user = userService.login(user);
		
		//登录成功后的处理
		if(user!=null){
			HttpSession session = request.getSession();
			session.setAttribute(User.SESSIONNAME, user);
			
			if(request.getParameter("remember")!=null){
				Cookie cookie = new Cookie(User.SESSIONNAME,user.getId().toString());
				cookie.setMaxAge(10*24*60*60*1000);
				
				response.addCookie(cookie);
			}
			
			response.sendRedirect(request.getContextPath()+"/home");
		}
		else{
			request.setAttribute("user",user);
			request.setAttribute("info", "用户不存在或者密码错误");
			
			request.getRequestDispatcher("/WEB-INF/pages/user/login.jsp").forward(request, response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

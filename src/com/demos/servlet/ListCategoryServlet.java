package com.demos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demos.entity.Category;
import com.demos.service.CategoryService;
import com.demos.service.impl.CategoryServiceImpl;

public class ListCategoryServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 获取所有菜系
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> list = categoryService.getCategories();
		
		//2 将菜系数据放入request对象
		request.setAttribute("categories", list);
		
		//3 转发到页面
		request.getRequestDispatcher("/WEB-INF/pages/category/list.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

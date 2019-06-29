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
		//1 ��ȡ���в�ϵ
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> list = categoryService.getCategories();
		
		//2 ����ϵ���ݷ���request����
		request.setAttribute("categories", list);
		
		//3 ת����ҳ��
		request.getRequestDispatcher("/WEB-INF/pages/category/list.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

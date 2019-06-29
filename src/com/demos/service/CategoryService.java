package com.demos.service;

import java.util.List;

import com.demos.entity.Category;

public interface CategoryService {
	public List<Category> getCategories();
	public void add(Category category);
}

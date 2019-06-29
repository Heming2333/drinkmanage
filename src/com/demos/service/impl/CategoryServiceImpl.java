package com.demos.service.impl;

import java.util.List;

import com.demos.core.exception.ReTryException;
import com.demos.dao.CategoryDao;
import com.demos.dao.impl.CategoryDaoImpl;
import com.demos.entity.Category;
import com.demos.entity.CategoryQueryModel;
import com.demos.entity.CategoryQueryModel;
import com.demos.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao categoryDao = new CategoryDaoImpl();
	@Override
	public List<Category> getCategories() {
		try {
			return categoryDao.getAll();
		} catch (Exception e) {
			throw new ReTryException("��������Ԥ֪�Ĵ���");
		}
	}

	@Override
	public void add(Category category) {
		if(category.getName()==null || category.getName().trim().length()==0){
			throw new ReTryException("��ϵ���Ʋ���Ϊ��");
		}
		
		try {
			CategoryQueryModel qm = new CategoryQueryModel();
			qm.setName(category.getName());
			if(categoryDao.getByCondition(qm).size()>0){
				throw new ReTryException("��ϵ�����Ѿ�����");
			}
			
			categoryDao.insert(category);
		} catch (Exception e) {
			throw new ReTryException("��������Ԥ֪�Ĵ���");
		}
		
	}

}

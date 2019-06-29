package com.demos.dao.impl;

import java.sql.ResultSet;

import com.demos.core.dao.BaseDaoImpl;
import com.demos.core.dao.BaseQueryModel;
import com.demos.dao.CategoryDao;
import com.demos.entity.Category;
import com.demos.entity.CategoryQueryModel;

public class CategoryDaoImpl extends BaseDaoImpl implements CategoryDao{

	@Override
	public String getSelectAllSql() {
		return "select * from categories";
	}

	@Override
	public String getSelectSql(BaseQueryModel queryModel) {
		CategoryQueryModel qm = (CategoryQueryModel)queryModel;
		StringBuilder sb = new StringBuilder();
		sb.append("select * from categories where 1=1");
		if(qm.getId()!=null){
			sb.append(" and id="+qm.getId());
		}
		if(qm.getName()!=null && qm.getName().trim().length()>0){
			sb.append(" and name='"+qm.getName()+"' ");
		}		
			
		return sb.toString();
	}

	@Override
	public String getInsertSql(Object data) {
		Category category = (Category)data;
		return "insert into categories(name) values('"+category.getName()+"')";
	}

	@Override
	public String getUpdateSql(Object data) {
		Category category = (Category)data;
		
		return "update categories set name='"+category.getName()+"' where id="+category.getId();
	}

	@Override
	public String getDeleteSql(int id) {
		return "delete from categories where id="+id;
	}

	@Override
	public Object rsToModel(ResultSet rs) throws Exception {
		Category category = new Category();
		category.setId(rs.getInt("id"));
		category.setName(rs.getString("name"));
				
		return category;
	}

}

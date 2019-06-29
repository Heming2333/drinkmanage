package com.demos.dao.impl;

import java.sql.ResultSet;

import com.demos.core.dao.BaseDaoImpl;
import com.demos.core.dao.BaseQueryModel;
import com.demos.dao.UserDao;
import com.demos.entity.User;
import com.demos.entity.UserQueryModel;

public class UserDaoImpl extends BaseDaoImpl implements UserDao{

	@Override
	public String getSelectAllSql() {
		return "select * from users";
	}

	@Override
	public String getSelectSql(BaseQueryModel queryModel) {
		UserQueryModel qm = (UserQueryModel)queryModel;
		StringBuilder sb = new StringBuilder();
		sb.append("select * from users where 1=1");
		if(qm.getId()!=null){
			sb.append(" and id="+qm.getId());
		}
		if(qm.getName()!=null && qm.getName().trim().length()>0){
			sb.append(" and name='"+qm.getName()+"' ");
		}
		if(qm.getPassword()!=null && qm.getPassword().trim().length()>0){
			sb.append(" and password='"+qm.getPassword()+"' ");
		}
			
		return sb.toString();
	}

	@Override
	public String getInsertSql(Object data) {
		User user = (User)data;
		return "insert into users(name,sex,birthday,idcard,password,freeze) values('"+user.getName()+"','"+user.getSex()+"',"+user.getBirthday()+",'"+user.getIdcard()+"','"+user.getPassword()+"','"+user.getFreeze()+"')";
	}

	@Override
	public String getUpdateSql(Object data) {
		User user = (User)data;
		
		return "update users set name='"+user.getName()+"',sex='"+user.getSex()+"',birthday="+user.getBirthday()+",idcard='"+user.getIdcard()+"',password='"+user.getPassword()+"',freeze='"+user.getFreeze()+"' where id="+user.getId();
	}

	@Override
	public String getDeleteSql(int id) {
		return "delete from users where id="+id;
	}

	@Override
	public Object rsToModel(ResultSet rs) throws Exception {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setSex(rs.getString("sex"));
		user.setBirthday(rs.getLong("birthday"));
		user.setIdcard(rs.getString("idcard"));
		user.setPassword(rs.getString("password"));
		user.setFreeze(rs.getString("freeze"));
		
		return user;
	}

}

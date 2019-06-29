package com.demos.service.impl;

import java.util.List;

import com.demos.core.exception.ReTryException;
import com.demos.dao.UserDao;
import com.demos.dao.impl.UserDaoImpl;
import com.demos.entity.User;
import com.demos.entity.UserQueryModel;
import com.demos.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(User user) {
		if(user.getName()==null || user.getName().trim().length()==0){
			throw new ReTryException("用户名不能为空");
		}
		if(user.getPassword()==null || user.getPassword().trim().length()==0){
			throw new ReTryException("登录密码不能为空");
		}
		
		UserQueryModel qm = new UserQueryModel();
		qm.setName(user.getName());
		qm.setPassword(user.getPassword());
		
		try {
			List<User> users =  userDao.getByCondition(qm);
			if(users.size()>0){
				return users.get(0);
			}
			else{
				return null;
			}
		} catch (Exception e) {
			throw new ReTryException("发生不可预知的错误");
		}
	}

}

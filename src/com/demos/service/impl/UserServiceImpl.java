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
			throw new ReTryException("�û�������Ϊ��");
		}
		if(user.getPassword()==null || user.getPassword().trim().length()==0){
			throw new ReTryException("��¼���벻��Ϊ��");
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
			throw new ReTryException("��������Ԥ֪�Ĵ���");
		}
	}

}

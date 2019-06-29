package com.demos.service.impl;

import org.junit.Test;

import com.demos.entity.User;
import com.demos.service.UserService;

import junit.framework.Assert;

public class TestUserServiceImpl {
	@Test
	public void testLogin() throws Exception{
		User user = new User();
		user.setName("admin");
		user.setPassword("123456");
		
		UserService userService = new UserServiceImpl();
		user = userService.login(user);
		
		Assert.assertNotNull(user);
	}
	
	@Test
	public void testLogin2() throws Exception{
		User user = new User();
		user.setName("admin2");
		user.setPassword("123456");
		
		UserService userService = new UserServiceImpl();
		user = userService.login(user);
		
		Assert.assertNull(user);
	}
}

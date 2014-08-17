package com.huangzb.test.business.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huangzb.test.business.IUserService;
import com.huangzb.test.model.User;
import com.huangzb.test.persiste.IUserDao;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDaoJpa;
	@Resource
	private IUserDao userDaoJdbc;
	
	public String getUserDesc() {
		return "welcome to use user service!";
	}

	@Transactional(rollbackFor=Exception.class)
	public void saveUserWithJpaAndJdbc(User user){
		userDaoJdbc.add(user);
		userDaoJpa.add(user);
	}
}

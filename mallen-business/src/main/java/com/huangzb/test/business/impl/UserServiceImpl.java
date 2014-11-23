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
		return "welcome to use user service! ";
	}

	@Transactional(rollbackFor = Exception.class)
	public void saveUserWithJpaAndJdbc(User user) {
		userDaoJdbc.add(user);
		userDaoJpa.add(user);
	}

	@Transactional(rollbackFor = Exception.class)
	public void testTransaction() throws Exception {
		try{
		User user = new User();
		user.setName("1");
		userDaoJpa.add(user);
		throw new Exception();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		// 使用了try...catch之后，数据就能保存了，说明限制了事务
	}
}

package com.huangzb.test.business;

import com.huangzb.test.model.User;

public interface IUserService {
	public String getUserDesc();
	
	public void saveUserWithJpaAndJdbc(User user);
}

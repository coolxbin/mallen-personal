package com.huangzb.test;

import javax.annotation.Resource;

import org.junit.Test;

import com.huangzb.test.business.IUserService;
import com.huangzb.test.model.User;

public class JpaAndJdbcTest extends AbstractTestCase{
	
	@Resource
	private IUserService userService;
	
	/**
	 * 測試同時使用jpa和jdbc保存數據，看是否能在一個事务中
	 */
	@Test
	public void testJpaAndJdbcSaveDataIntercurrent(){
		User u = new User();
		u.setName("同時使用jpa和jdbc保存數據");
		userService.saveUserWithJpaAndJdbc(u);
	}
}

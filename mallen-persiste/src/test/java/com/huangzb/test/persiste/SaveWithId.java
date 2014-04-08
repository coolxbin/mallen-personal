package com.huangzb.test.persiste;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.huangzb.test.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext/applicationContext.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class SaveWithId {
	@Resource
	private IUserDao userDaoJpa;
	
	@Test
	public void testSaveWithId(){
		User u = new User("save with id");
		/**
		 * 未找到合适的方式来实现，如果在model上使用自动生成id策略，则在这儿定义了id会抛出游离态错误。
		 */
//		u.setId("test");
		
		
		userDaoJpa.add(u);
	}
}

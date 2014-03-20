package com.huangzb.test.jpahibernatejta;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JpaHibernateJtaTest {
	private static ApplicationContext ctx = null;
	private static TestService testService = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext(
				"applicationContext/applicationContext.xml");
		testService = (TestService) ctx.getBean("testService");
	}

	@Test
	public void test() {
		testService.test();
	}

}

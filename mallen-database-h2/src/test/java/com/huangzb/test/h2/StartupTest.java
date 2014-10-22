package com.huangzb.test.h2;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class StartupTest {
	private static Logger log = LoggerFactory.getLogger(StartupTest.class);

	@Resource
	private JdbcTemplate jdbc;

	@Test
	public void testStartupH2() {
		String addSql = "insert into user(id, name) values('1', 'user1')";
		this.jdbc.execute(addSql);
		addSql = "insert into user(id, name) values('2', 'user2')";
		this.jdbc.execute(addSql);

		Long count = (Long) this.jdbc.queryForObject(
				"select count(*) from user", Long.class);
		Assert.assertEquals(new Long(2L), count);
		log.debug("运行完毕");
	}
}

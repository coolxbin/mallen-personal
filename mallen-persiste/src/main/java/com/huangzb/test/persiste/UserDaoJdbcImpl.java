package com.huangzb.test.persiste;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.huangzb.test.model.User;
import com.huangzb.test.persiste.common.UUIDGenerator;

@Repository("userDaoJdbc")
public class UserDaoJdbcImpl implements IUserDao {
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public void add(User user) {
		StringBuffer sb = new StringBuffer("insert into user values(?, ?)");
		jdbcTemplate.update(sb.toString(), UUIDGenerator.generate(), user.getName());
	}

}

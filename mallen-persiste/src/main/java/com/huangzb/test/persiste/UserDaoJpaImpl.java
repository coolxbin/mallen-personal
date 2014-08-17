package com.huangzb.test.persiste;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.huangzb.test.model.User;

@Repository("userDaoJpa")
public class UserDaoJpaImpl implements IUserDao{
	@PersistenceContext
	private EntityManager em;
	
	public void add(User user) {
		em.persist(user);
	}
	
}

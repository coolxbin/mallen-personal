package com.huangzb.test.hql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import com.huangzb.test.model.User;

public class HqlInTest extends AbstractTestCase {
	@PersistenceContext
	private EntityManager em;

	@Before
	public void init() {
		User u1 = new User("USER1");
		User u2 = new User("USER2");
		User u3 = new User("USER3");
		User u4 = new User("USER4");

		em.persist(u1);
		em.persist(u2);
		em.persist(u3);
		em.persist(u4);
	}

	@Test
	public void testHqlIn() {
		String xql = "from User where name in (:names)";
		List<String> names = new ArrayList<>();
		names.add("USER1");
		names.add("USER2");
		System.out.println(names);
		Query q = em.createQuery(xql);
		q.setParameter("names", names);

		@SuppressWarnings("unchecked")
		List<User> users = q.getResultList();
		
		System.out.println(users.size());
	}
}

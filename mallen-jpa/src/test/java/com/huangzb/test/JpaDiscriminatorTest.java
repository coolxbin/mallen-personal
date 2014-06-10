package com.huangzb.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;

import com.huangzb.test.jpa.model.Email;
import com.huangzb.test.jpa.model.Phone;
import com.huangzb.test.jpa.model.User;

public class JpaDiscriminatorTest extends AbstractTestCase{
	@PersistenceContext
	private EntityManager em;
	
	@Test
	public void testReadDiscriminatorList(){
		String xql = "from User where name=:name";
		Query q = em.createQuery(xql);
		q.setParameter("name", "zoma");
		User u = (User) q.getSingleResult();
		assertNotNull(u);
		assertNotNull(u.getPhones());
		assertEquals(1, u.getPhones().size());
		assertNotNull(u.getEmails());
		assertEquals(1, u.getEmails().size());
//		User u = new User();
//		u.setName("zoma");
//		Phone p = new Phone();
//		p.setValue("1");
//		p.setUser(u);
//		
//		Email e = new Email();
//		e.setValue("x@x.com");
//		e.setUser(u);
//		
//		em.persist(u);
//		em.persist(p);
//		em.persist(e);
	}
}

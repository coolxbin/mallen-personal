package com.huangzb.test.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.huangzb.test.hibernate.model.User;

public class HibernateTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	public void test() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		
		String hql = "from User where name=:name";
		Query q = s.createQuery(hql);
		q.setString("name", "mallen");
		User user = (User) q.uniqueResult();
		
		assertNotNull(user);
		assertEquals(1, user.getEmails().size());
		assertEquals(1, user.getPhones().size());
		
		s.getTransaction().commit();
	}

}

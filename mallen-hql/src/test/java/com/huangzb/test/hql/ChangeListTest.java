package com.huangzb.test.hql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.huangzb.test.model.Company;
import com.huangzb.test.model.User;

public class ChangeListTest extends AbstractTestCase{
	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Rollback(false)
	public void testChangeList(){
		Company company1 = em.createQuery("from Company where name=?", Company.class).setParameter(1, "company1").getSingleResult();

		Query q = em.createQuery("delete from User where company.id = ?");
		q.setParameter(1, company1.getId());
		q.executeUpdate();
		
		User newUser1 = new User("new user1");
		newUser1.setCompany(company1);
		List<User> newUsers = new ArrayList<>();
		newUsers.add(newUser1);
		
		company1.setUsers(newUsers);
		em.merge(company1);
	}
	
	@Test
	@Rollback(false)
	public void addData(){
		Company company1 = new Company("company1");
		User user1 = new User("company1 user1");
		User user2 = new User("company1 user2");
		user1.setCompany(company1);
		user2.setCompany(company1);
		
		Company company2 = new Company("company2");
		User user21 = new User("company2 user1");
		User user22 = new User("company2 user2");
		user21.setCompany(company2);
		user22.setCompany(company2);
		
		company1.getUsers().add(user1);
		company1.getUsers().add(user2);
		company2.getUsers().add(user21);
		company2.getUsers().add(user22);
		
		em.persist(company1);
		em.persist(company2);
//		System.out.println("finish");
	}
}

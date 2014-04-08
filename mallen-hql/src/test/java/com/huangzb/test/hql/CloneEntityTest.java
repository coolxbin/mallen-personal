package com.huangzb.test.hql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.huangzb.test.model.Company;
import com.huangzb.test.model.User;

public class CloneEntityTest extends AbstractTestCase{
	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Rollback(false)
	public void testCloneEntity(){
		Company company1 = em.createQuery("from Company where name=?", Company.class).setParameter(1, "company1").getSingleResult();
		em.refresh(company1);
		
		emptyId(company1);

		em.detach(company1);
		
		
		em.merge(company1);
	}
	
	public void emptyId(Company company){
		company.setId(null);
		List<User> users = company.getUsers();
		for(User user : users){
			user.setId(null);
		}
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
		
		em.persist(user1);
		em.persist(user2);
		em.persist(user21);
		em.persist(user22);
		
		em.persist(company1);
		em.persist(company2);
		em.flush();
//		System.out.println("finish");
	}
}

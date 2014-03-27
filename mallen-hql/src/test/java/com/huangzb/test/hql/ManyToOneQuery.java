package com.huangzb.test.hql;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.springframework.orm.jpa.JpaTransactionManager;

import com.huangzb.test.model.Company;
import com.huangzb.test.model.User;

public class ManyToOneQuery extends AbstractTestCase {
	@Resource
	private CompanyService companyService;
	@PersistenceContext
	private EntityManager em;
	@Resource
	private JpaTransactionManager transactionManager;

	@Test
	public void testQuery() {
		Company company = new Company();
		company.setName("companyHello");
		
		User u1 = new User("u1Hello");
		User u2 = new User("u2Hello");
		
		em.persist(u1);
		em.persist(u2);
		
		
		u1.setCompany(company);
		u2.setCompany(company);
		
		em.persist(company);
		em.flush();
		em.refresh(company);
		
		Company company1 = em.find(Company.class, company.getId());
		System.out.println(company1.getUsers().size());
		
	}
}

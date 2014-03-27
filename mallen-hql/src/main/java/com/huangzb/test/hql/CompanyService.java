package com.huangzb.test.hql;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huangzb.test.model.Company;
import com.huangzb.test.model.User;

@Service("companyService")
@Transactional
public class CompanyService {
	@PersistenceContext
	private EntityManager em;
	
	public String test(){
		Company company = new Company();
		company.setName("companyHello");
		
		User u1 = new User("u1Hello");
		User u2 = new User("u2Hello");
		
		em.persist(u1);
		em.persist(u2);
		
		
		u1.setCompany(company);
		u2.setCompany(company);
		
		em.persist(company);
		
		return company.getId();
	}
	
	public int query(String id){
		Company company1 = em.find(Company.class, id);
		return company1.getUsers().size();
	}
}

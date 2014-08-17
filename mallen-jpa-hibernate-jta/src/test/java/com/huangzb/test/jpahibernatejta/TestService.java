package com.huangzb.test.jpahibernatejta;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huangzb.test.model.hibernate.HibernateModel;
import com.huangzb.test.model.jpa.JpaModel;

@Service("testService")
@Transactional(rollbackFor=Throwable.class)
public class TestService {
	@PersistenceContext
	private EntityManager em;
	@Resource
	private SessionFactory sf;
	
	public void test(){
		HibernateModel hm = new HibernateModel("hibernate model");
		JpaModel jm = new JpaModel("jpa model");
		
		em.persist(jm);
		sf.getCurrentSession().save(hm);
		
	}
}

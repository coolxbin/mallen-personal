package com.huangzb.test.manytomany;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.huangzb.test.AbstractTestCase;
import com.huangzb.test.jpa.model.manytomany.Permission;
import com.huangzb.test.jpa.model.manytomany.Role;

/**
 * 测试jpa多对多，主要测试在不删除model的时候，删除关系
 * @author mallen
 *
 */
public class JpaManyToManyTest extends AbstractTestCase{
	@PersistenceContext
	private EntityManager em;
	
//	@Before
	public void initData(){
		Role r1 = new Role("role1");
		Role r2 = new Role("role2");
		Role r3= new Role("role3");
		
		Permission p1 = new Permission("只读", "1");
		Permission p2 = new Permission("只写", "2");
		Permission p3 = new Permission("读写", "3");
		
		r1.getPermissions().add(p1);
		r2.getPermissions().add(p1);
		r2.getPermissions().add(p2);
		r3.getPermissions().add(p3);
		
		em.persist(r1);
		em.persist(r2);
		em.persist(r3);
	}
	
	@Test
	@Rollback(false)
	public void test(){
		Role r2 = em.find(Role.class, "cfe64c9e-2475-4896-b138-7ffb189ed854");
		Set<Permission> ps = r2.getPermissions();
		Permission p = ps.iterator().next();
		String name = p.getName();
		System.out.println("删除的permission为"+name);
		r2.getPermissions().remove(p);
		
		em.merge(r2);
		
		System.out.println("finish");
	}
}

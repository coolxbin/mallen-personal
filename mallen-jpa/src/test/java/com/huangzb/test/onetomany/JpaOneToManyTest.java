package com.huangzb.test.onetomany;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.huangzb.test.AbstractTestCase;
import com.huangzb.test.jpa.model.onetomany.Company;
import com.huangzb.test.jpa.model.onetomany.Person;

/**
 * 测试jpa一对多
 * 测试时，先使用before方法将数据写入数据库，然后将对应测试方法的id修改为数据库对应的id才能完成测试。
 * @author mallen
 *
 */
public class JpaOneToManyTest extends AbstractTestCase{
	@PersistenceContext
	private EntityManager em;
	
//	@Before
	public void initData(){
		Company company = new Company("company");
		
		Person p1 = new Person("person1", company);
		Person p2 = new Person("person2", company);
		Person p3 = new Person("person3", company);
		
		company.getPersons().add(p1);
		company.getPersons().add(p2);
		company.getPersons().add(p3);
		
		em.persist(company);
	}
	
//	@Test
//	@Rollback(false)
	public void testDeleteFromOne(){
		Company company = em.find(Company.class, "4ce7ce23-b9b0-4d0b-a1ee-9670400bc272");
		Set<Person> ps = company.getPersons();
		Person p = ps.iterator().next();
		System.out.println("删除的person为:"+p.getName());
		// 不能删除对应的记录
		/**解释：这种方式来删除多方记录是无效的。
		 * 1、首先，此处调用的是merge方法，在一方设置的merge级联只是用于更新多方的信息，如：person的name更新了之后
		 * 只需要em.merge(company);则可以将person的name更新，而不需要再调用em.merge(person);
		 * 2、如果想要从输出库删除某条model记录，首先得从hibernate的缓存中移除，将该对象变为游离对象，然后当hibernate
		   flush的时候才能将对应的数据库记录删除。
		   3、对于多对多关系来说，如果在任意一方使用类似company.getXXXs().remove(obj);的代码时，将会把中间表的对应记录删除，
		   这个结果与一对多的测试一致。
		   因为在一对多关系中，一方是使用的mappedby，已经将关系控制反转到了多方，所以使用company.getPersons().remove(p);时，
		  既不会移除关系，也不会删除多方的记录。
		  如果不使用mappedby，hibernate将会创建一张中间表，在使用company.getPersons().remove(p);时，由于在一方设置的是
		  级联更新，所以会将中间表的对应记录删除，而不会影响到两张表的数据和记录。
		*/
		company.getPersons().remove(p);
		
		em.merge(company);
		System.out.println("finish");
	}
	
//	@Test
//	@Rollback(false)
	public void testDeleteRalationFromMany(){
		// 测试从多方删除关系
		// 结果：这样之后多方记录的外键被设置为了null
		Person p = em.find(Person.class, "ee025970-0d29-4d46-a493-9ae203250100");
		p.setCompany(null);
		
		em.merge(p);
		
		System.out.println("finish");
	}
	
//	@Test
//	@Rollback(false)
	public void testDeleteOne(){
		// 测试删除一方，看是否多方会被删除?
		// 答：会被删除，应为多方设置了级联删除
		Company company = em.find(Company.class, "4ce7ce23-b9b0-4d0b-a1ee-9670400bc272");
		em.remove(company);
		
		System.out.println("finish");
	}
	
	@Test
	@Rollback(false)
	public void testDeleteRelationshipFromOne(){
		// 测试从一方删除关系，这时一方未使用mappedby属性，hibernate将会自动创建中间表
		// 结果：使用remove方法，将会把中间表中的对应数据移除，而不会影响到其他两张表。
		Company company = em.find(Company.class, "773922f0-4d33-4c2d-8c53-1d851d9972fd");
		Set<Person> ps = company.getPersons();
		Person p = ps.iterator().next();
		System.out.println("删除的person为:"+p.getName());
		company.getPersons().remove(p);
		
		em.merge(company);
		System.out.println("finish");
	}
}

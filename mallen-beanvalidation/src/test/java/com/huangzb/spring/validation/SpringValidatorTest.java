package com.huangzb.spring.validation;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huangzb.bean.ValidateBean;
import com.huangzb.service.ValidationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringValidatorTest {
	@Resource
	private ValidationService vs;

	@Test
	public void test() {
		/*HbvBean hbv = new HbvBean(null, 1);
		Set<ConstraintViolation<HbvBean>> constraintViolations = validator
				.validate(hbv);
		for (ConstraintViolation<HbvBean> constraintViolation : constraintViolations) {
			System.out.println(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
		}*/
		ValidateBean hbv = new ValidateBean(null, 1);
		vs.validateParam(hbv);
	}

}
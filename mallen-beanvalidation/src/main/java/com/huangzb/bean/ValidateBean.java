package com.huangzb.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ValidateBean {
	@NotNull
	private String name;
	@Min(18)
	@Max(100)
	private int age;

	public ValidateBean() {
	}

	public ValidateBean(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "name:" + this.getName() + ", age:" + this.getAge();
	}

}

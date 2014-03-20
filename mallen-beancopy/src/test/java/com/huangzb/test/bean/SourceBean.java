package com.huangzb.test.bean;

public class SourceBean {
	private String name;
	private int age;
	private String sex;
	private SourceInnerBean innerBean;

	public SourceBean(String name, int age) {
		super();
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public SourceInnerBean getInnerBean() {
		return innerBean;
	}

	public void setInnerBean(SourceInnerBean innerBean) {
		this.innerBean = innerBean;
	}

	@Override
	public String toString() {
		return "SourceBean:name = " + name + ", age = " + age + ", sex = "
				+ sex;
	}

}

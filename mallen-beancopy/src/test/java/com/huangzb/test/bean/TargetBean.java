package com.huangzb.test.bean;

public class TargetBean {
	private String name;
	private int age;
	private String address;
	private TargetInnerBean innerBean;
	private SourceInnerBean sib;
	
	public String toString() {
		return "TargetBean:name = " + name + ", age = " + age + ", address = "
				+ address + ", innerBean = " +innerBean + ", sib = " + sib;
	}

	public TargetBean() {
		super();
	}

	public TargetBean(String name, int age) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public TargetInnerBean getInnerBean() {
		return innerBean;
	}

	public void setInnerBean(TargetInnerBean innerBean) {
		this.innerBean = innerBean;
	}
}

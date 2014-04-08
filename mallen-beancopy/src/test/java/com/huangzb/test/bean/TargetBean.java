package com.huangzb.test.bean;

import java.io.File;
import java.util.Date;

public class TargetBean {
	private String name;
	private int age;
	private String address;
	private Date createTime;
	private File file;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String toString() {
		return "TargetBean:name = " + name + ", age = " + age + ", address = "
				+ address + " createTime=" + createTime + " filename = " + file.getName();
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}

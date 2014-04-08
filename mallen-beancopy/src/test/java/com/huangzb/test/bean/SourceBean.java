package com.huangzb.test.bean;

import java.io.File;

public class SourceBean {
	private String name;
	private int age;
	private String sex;
	private String createTime;
	private File file;

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

	// 这儿是不能定义返回值为String的，因为target中的是date，copier不会来调用该方法
	// public String getCreateTime() {
	// return DateUtil.dateTimeToStr(createTime);
	// }

	// public Date getCreateTime() {
	// return createTime;
	// }
	//
	// public void setCreateTime(Date createTime) {
	// this.createTime = createTime;
	// }

	@Override
	public String toString() {
		return "SourceBean:name = " + name + ", age = " + age + ", sex = "
				+ sex;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}

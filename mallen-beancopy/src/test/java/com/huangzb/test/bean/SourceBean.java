package com.huangzb.test.bean;

import java.util.Date;

public class SourceBean {
	private String name;
	private int age;
	private String sex;
	private SourceInnerBean innerBean;
	private Date createTime;

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
// 这儿是不能定义返回值为String的，因为target中的是date，copier不会来调用该方法
//	public String getCreateTime() {
//		return  DateUtil.dateTimeToStr(createTime);
//	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SourceBean:name = " + name + ", age = " + age + ", sex = "
				+ sex;
	}

}

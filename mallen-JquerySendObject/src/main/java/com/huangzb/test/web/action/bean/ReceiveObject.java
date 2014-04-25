package com.huangzb.test.web.action.bean;

import java.util.List;


public class ReceiveObject {
	private String id;
	private String name;
	private List<TestModel> models;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TestModel> getModels() {
		return models;
	}

	public void setModels(List<TestModel> models) {
		this.models = models;
	}

}

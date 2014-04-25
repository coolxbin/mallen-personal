package com.huangzb.test.web.action;

import java.io.IOException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.codehaus.jackson.map.ObjectMapper;

import com.huangzb.test.web.action.bean.ReceiveObject;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/receiveObject")
@ResultPath("/WEB-INF/views")
@ParentPackage("json-default")
public class ReceiveObejctAction extends ActionSupport {
	private static final long serialVersionUID = 2957101194563734376L;

	@Action(value = "receiveObject", results = { @Result(name = "success", type = "json") })
	public String receiveObject() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			ReceiveObject ro = mapper.readValue(jsonString, ReceiveObject.class);
			System.out.println(ro);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	private String jsonString;

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}
}

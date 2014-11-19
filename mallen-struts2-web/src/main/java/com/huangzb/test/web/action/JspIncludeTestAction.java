package com.huangzb.test.web.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.huangzb.test.business.IUserService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("jspIncludeTestAction")
@Namespace("/jspinclude")
@ResultPath("/views")
@ParentPackage("json-default")
@Scope(value = "prototype")
public class JspIncludeTestAction extends ActionSupport{
	private static final long serialVersionUID = -3792805743270963317L;
	private String path;
	private Map<String, String> entityMap;
	@Resource
	private IUserService userService;
	
	@Action(value="test", results={@Result(name="success",location="JspIncludeTest.jsp")})
	public String test(){
		path = "innerPage2.jsp";
		entityMap = new HashMap<String, String>();
		entityMap.put("key1", "hello");
		entityMap.put("key2", " ,world");
		return SUCCESS;
	}
	
	@Action(value="testTrans", results={@Result(name="success",location="JspIncludeTest.jsp")})
	public String testTransaction(){
		try {
			userService.testTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public Map<String, String> getEntityMap() {
		return entityMap;
	}


	public void setEntityMap(Map<String, String> entityMap) {
		this.entityMap = entityMap;
	}


	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}

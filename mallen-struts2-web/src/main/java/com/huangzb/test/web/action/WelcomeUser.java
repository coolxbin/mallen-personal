package com.huangzb.test.web.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.huangzb.test.business.IUserService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * struts2需要Convention plug-in来支持注解，该插件的使用规则如下：
 * 1、插件默认将会把strut、struts2、action或者actions的包路劲下所有类处理成controller(action)，
 * 	包路劲如
 * 	com.test.action.HelloWorld.class
 *  com.test.action.hello.HelloWorld.class
 *  这两种方式生成的action名字都是hello-world，但是属于不同的namespace，第一个属于default namespace，第二个属于hello namespace.
 *  由此可知，插件在识别了关键字之后，其后的包路劲会被处理成表空间，对应于url类似于/hello/hello-world
 * 2、action class必须满足以下两个条件中的一个：
 *	1.实现com.opensymphony.xwork2.Action
 * 	2.类名以Action结尾
 * 3、插件使用类名来映射出action的URL，比如WelcomeUser->welcome-user，WelcomeMyDear->welcome-my-dear
 * 4、对于返回结果，插件会在默认目录WEB-INF/content目录中去查找返回页面
 * 5、插件最后会根据返回结果来寻找页面，比如welcome-user返回的是success。则会在默认目录中寻找welcome-user-success.jsp或者welcome-user.jsp；
 * 如果返回结果是input，则会寻找welcome-user-input.jsp，当然，返回页面不限于jsp页面，在此仅仅是为了说明返回页面的名称。
 * 6、可以利用struts2的注解来改变命名空间，action名称，返回结果等数据。
 * @author Administrator
 *
 */
public class WelcomeUser extends ActionSupport {
	private static final long serialVersionUID = 6371123870499844841L;

	private String userName;
	private String message;
	
	@Resource
	private IUserService userService;
	
	public String execute() {
		message = "Welcome " + userName;
		return SUCCESS;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getMessage() {
		return message;
	}

}

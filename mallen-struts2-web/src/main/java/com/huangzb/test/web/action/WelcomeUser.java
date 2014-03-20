package com.huangzb.test.web.action;

import javax.annotation.Resource;

import com.huangzb.test.business.IUserService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * struts2��ҪConvention plug-in��֧��ע�⣬�ò����ʹ�ù������£�
 * 1�����Ĭ�Ͻ����strut��struts2��action����actions�İ�·���������ദ���controller(action)��
 * 	��·����
 * 	com.test.action.HelloWorld.class
 *  com.test.action.hello.HelloWorld.class
 *  �����ַ�ʽ���ɵ�action���ֶ���hello-world���������ڲ�ͬ��namespace����һ������default namespace���ڶ�������hello namespace.
 *  �ɴ˿�֪�������ʶ���˹ؼ���֮�����İ�·���ᱻ����ɱ�ռ䣬��Ӧ��url������/hello/hello-world
 * 2��action class���������������������е�һ����
 *	1.ʵ��com.opensymphony.xwork2.Action
 * 	2.������Action��β
 * 3�����ʹ��������ӳ���action��URL������WelcomeUser->welcome-user��WelcomeMyDear->welcome-my-dear
 * 4�����ڷ��ؽ�����������Ĭ��Ŀ¼WEB-INF/contentĿ¼��ȥ���ҷ���ҳ��
 * 5�����������ݷ��ؽ����Ѱ��ҳ�棬����welcome-user���ص���success�������Ĭ��Ŀ¼��Ѱ��welcome-user-success.jsp����welcome-user.jsp��
 * ������ؽ����input�����Ѱ��welcome-user-input.jsp����Ȼ������ҳ�治����jspҳ�棬�ڴ˽�����Ϊ��˵������ҳ������ơ�
 * 6����������struts2��ע�����ı������ռ䣬action���ƣ����ؽ�������ݡ�
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

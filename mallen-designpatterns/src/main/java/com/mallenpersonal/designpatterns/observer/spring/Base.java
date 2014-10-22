package com.mallenpersonal.designpatterns.observer.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Base {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/mallenpersonal/designpatterns/observer/spring/applicationContext.xml");
		Publisher pub = (Publisher) ctx.getBean("publisher");
		pub.publish("测试spring观察者模式");
	}
}

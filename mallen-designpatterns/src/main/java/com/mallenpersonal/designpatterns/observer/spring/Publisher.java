package com.mallenpersonal.designpatterns.observer.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Publisher implements ApplicationContextAware {
	private ApplicationContext ctx;
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.ctx = applicationContext;
	}

	public void publish(String msg){
		ctx.publishEvent(new MessageEvent(this, msg));
	}
}

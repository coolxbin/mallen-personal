package com.mallenpersonal.designpatterns.observer.spring;

import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {
	private static final long serialVersionUID = -4525475233838568314L;
	
	private String msg;
	
	public MessageEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}

	public Object getSource() {
		return super.getSource();
	}

	public String toString() {
		return super.toString();
	}

	public String getMsg() {
		return msg;
	}
	
}

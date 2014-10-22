package com.mallenpersonal.designpatterns.observer.spring;

import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {

	public void onApplicationEvent(MessageEvent event) {
		System.out.println("发布的消息为：" + event.getMsg());
	}

}

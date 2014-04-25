package com.huangzb.test.jdk8.newinterface;

public interface HasDefaultMethodInterface {
	public default void sayHello(){
		System.out.println("this is default say hello");
	}
}

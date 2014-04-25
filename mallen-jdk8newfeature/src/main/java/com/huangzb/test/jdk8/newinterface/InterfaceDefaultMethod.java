package com.huangzb.test.jdk8.newinterface;

public class InterfaceDefaultMethod {
	public static void main(String[] args) {
//		HasDefaultMethodInterface hdi1 = new HasDefaultMethodInterface(){};
//		hdi1.sayHello();
		HasDefaultMethodInterface hdi2 = new ChildInterface();
		hdi2.sayHello();
	}
}

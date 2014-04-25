package com.huangzb.test.jdk8.functionalinterface;

@FunctionalInterface
public interface FunctionalInterfaceAnnotation {
	public void hello();

	public default void sayHello() {
		System.out.println("this is default say hello");
	}
}

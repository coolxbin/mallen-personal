package com.huangzb.test.jdk8.functionalinterface;

public class Tester {
	public static void main(String[] args) {
		FunctionalInterfaceAnnotation fia = ()->{System.out.println("this is funcational interface lambdas");};
		fia.hello();
	}
}

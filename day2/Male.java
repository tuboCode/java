package com.cs.cn;

public class Male implements Human {

	public void eat() {
		System.out.println("Male can eat");
	}

	@Override
	public void sleep() {
		System.out.println("Male can sleep");
	}

	@Override
	public void beat() {
		System.out.println("Male can beat");

	}

}

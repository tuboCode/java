package com.cs.cn;
//����ģʽ
public class Wife {
	
	private static final Wife wife = new Wife();
	
	private Wife() {}
	
	public static Wife getWife(){
		return new Wife();
	}
}

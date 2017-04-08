package com.cs.cn;
//¶öººÄ£Ê½
public class Wife {
	
	private static final Wife wife = new Wife();
	
	private Wife() {}
	
	public static Wife getWife(){
		return new Wife();
	}
}

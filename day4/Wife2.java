package com.cs.cn;
//线程安全
public class Wife2 {
	private static Wife2 wife2;
	
	private Wife2(){}
	
	public static Wife2 getWife(){
		if(wife2==null){
			wife2 = new Wife2();
		}
		return wife2;
	}
}

package com.cs.cn;

public class StaticFactory {
	public static Male createMale(){
		return new Male();
	}
	public static Female createFemale(){
		return new Female();
	}
}

package com.cs.cn;

public class HumanFactory {
	public Human creatHuman(String gender){
		if(gender.equals("male")){
			return new Male();
		}
		if(gender.endsWith("female")){
			return new Female();
		}
		else{
			System.out.println("请输入正确的类型");
			return null;
		}
	}
}

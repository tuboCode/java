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
			System.out.println("��������ȷ������");
			return null;
		}
	}
}

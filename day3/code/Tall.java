package com.cs.cn;

public class Tall extends GirlDecorator{
	private Girl girl;
	
	public Tall(Girl g){
		girl = g;
	}
	
	public String getDescription(){
		return girl.getDescription() + "is very tall";
	}

}

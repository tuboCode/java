package com.cs.cn;

public class GoldenHair extends GirlDecorator{
	private Girl girl;
	
	public GoldenHair(Girl g){
		girl = g;
	}
	
	public String getDescription(){
		return girl.getDescription() + "with gloden hair";
	}
}


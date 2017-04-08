package com.cs.cn;

public class MultipleFactory {
	public Male createMale(){
		return new Male();
	}
	public Female createFemale(){
		return new Female();
	}
}

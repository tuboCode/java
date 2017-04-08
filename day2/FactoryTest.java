package com.cs.cn;

public class FactoryTest {
	
	public static void main(String[] args){
//		MultipleFactory factory = new MultipleFactory();
		
		Human male = StaticFactory.createMale();
		
		male.beat();
		male.eat();
		male.sleep();
	}
}

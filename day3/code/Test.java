package com.cs.cn;

public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Girl g1 = new AmericanGirl();
		System.out.println(g1.getDescription());
		
		GoldenHair g2 = new GoldenHair(g1);
		System.out.println(g2.getDescription());
		
		Tall g3 = new Tall(g2);
		System.out.println(g3.getDescription());
	}

}

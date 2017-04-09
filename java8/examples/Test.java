package com.cs.cn;

import java.util.List;
import java.util.ArrayList;

public class Test {

	final static String salutaion = "Hello";

	public static void main(String[] args) {
		
		List names = new ArrayList();
		
		names.add("Peter");
		names.add("sdf");
		names.add("fsf");
		names.add("sfsdf");
		
		names.forEach(System.out::println);
	}

}

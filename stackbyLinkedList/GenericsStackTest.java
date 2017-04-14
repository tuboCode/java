package com.cs.cn;

public class GenericsStackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenericStack<String> stack  = new GenericStack<>();
		
		System.out.println("Now add some words into stack.");
		
		stack.push("helloWord");
		System.out.println("ssd");
		stack.push("our");
		System.out.println("our added");
		
		while(!stack.isEmpty()){
			String s = (String)stack.pop();
			
			System.out.println("word" + s + "has been take out");
		}
		
	}

}

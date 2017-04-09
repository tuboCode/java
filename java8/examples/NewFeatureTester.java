package com.cs.cn;

public class NewFeatureTester {
	final static String salutation = "hello";		//不可再次赋值
	//static String salutation = "hello";
	
	//String salutation = "helloa";
	
	//final saultion = "hellowe";
	
	public static void main(String[] args){
		//final static String salutation  = "hello;"
		
		GreetingService greetingservice = message ->
		System.out.println(salutation + message);
		greetingservice.sayMessage("shiyanlou");
	}
	
	interface GreetingService{
		void sayMessage(String message);
	}
}

package com.cs.cn;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneBookByMap {
	
	public static void main(String[] args){
		
		HashMap<String,String> phonebook = new HashMap<String,String>();
		
		Scanner scan = new Scanner(System.in);
		
		String keyword = new String();
		
		phonebook = initPhoneBook(phonebook);
		
		System.out.println("please input a name that you want to search:");
		
		keyword = scan.nextLine();
		
		while(keyword.isEmpty()){
			System.out.println("please input a name !");
			keyword = scan.nextLine();
		}
		
		System.out.println("the result is :");
		System.out.println(queryPhoneBook(phonebook,keyword));
		scan.close();
	}
	 // 该方法用于完成指定HashMap的初始化，为其装入一些号码数据，你也可以自定义这些数据
	private static HashMap<String,String> initPhoneBook(HashMap<String,String>phonebook){
		
		phonebook.put("tom", "110");
		phonebook.put("jack","120");
		phonebook.put("ruise", "119");
		
		return phonebook;
	}
	private static String queryPhoneBook(HashMap<String, String>phonebook,String keyword){
		
		String result = new String();
		
		result = phonebook.get(keyword);
		
		if(result == null){
			return "Can not find this user.";
		}
		
		return result;
	}
}

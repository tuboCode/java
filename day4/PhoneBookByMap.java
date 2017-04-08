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
	 // �÷����������ָ��HashMap�ĳ�ʼ����Ϊ��װ��һЩ�������ݣ���Ҳ�����Զ�����Щ����
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

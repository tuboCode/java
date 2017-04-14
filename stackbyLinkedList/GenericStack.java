package com.cs.cn;

import java.util.LinkedList;

public class GenericStack<T> {
	
	private LinkedList<T> stackContainer = new LinkedList<T>();
	
	//ÈëÕ»
	public void push(T t){
		stackContainer.addFirst(t);
	}
	
	//³öÕ»
	public T pop(){
		return stackContainer.removeFirst();
	}
	
	public boolean isEmpty(){
		return stackContainer.isEmpty();
	}
}

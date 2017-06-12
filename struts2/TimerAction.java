package com.Hello;

import com.opensymphony.xwork2.ActionSupport;

public class TimerAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		for(int i=0;i<10000;i++){
			System.out.println("ÎÒÒªÅ£±Æ");
		}
		return SUCCESS;
	}
}

package com.Hello.Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/*
 * ����action���ѵ�ʱ��
 */
public class TimerInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//ִ��Action֮ǰ
		long start = System.currentTimeMillis();
		//ִ����һ����������������Ѿ������һ����������ִ����һ��Ŀ��Action
		String result = invocation.invoke();
		//3ִ��Action���
		long end = System.currentTimeMillis();
		System.out.println("ִ��Action���ѵ�ʱ��   " +(end - start));
		return result;
	}

}

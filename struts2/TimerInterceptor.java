package com.Hello.Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/*
 * 计算action花费的时间
 */
public class TimerInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//执行Action之前
		long start = System.currentTimeMillis();
		//执行下一个人拦截器，如果已经是最后一个拦截器，执行下一个目标Action
		String result = invocation.invoke();
		//3执行Action最后
		long end = System.currentTimeMillis();
		System.out.println("执行Action花费的时间   " +(end - start));
		return result;
	}

}

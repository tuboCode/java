package com.cs.cn;

public class Wife3 {
	
	private static Wife3 wife3;
	
	private volatile Wife3(){}
	
	public static synchronized Wife3 getWife3(){
		if(wife3==null){
			return new Wife3();
		}
		return wife3;
	}
}
	
	/*public static  Wife3 getWife3(){
		if(wife3==null){
			synchronized (Wife.class){
				if(wife3==null){
					wife3 = new wife3();
				}
			}
		}
		return wife3;
	}
}
*/

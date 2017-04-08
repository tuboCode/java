package com.cs.cn;

public class Wife4 {
	
	private static class WifeHolder{
		private static final Wife4 wife4 = new Wife4();
	}
	private Wife4() {}
	
	public static Wife4 getWife4(){
		return WifeHolder.wife4;
	}
}

package com.cs.cn;

class AKitchen implements KitchenFactory {
	public Food getfood(){
		return new Apple();
	}
	
	public TableWare getTableWare(){
		return new Knife();
	}

	@Override
	public Food getFood() {
		// TODO Auto-generated method stub
		return null;
	}

}

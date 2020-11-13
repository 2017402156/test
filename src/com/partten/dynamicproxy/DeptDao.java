package com.partten.dynamicproxy;

public class DeptDao implements Dao{

	@Override
	public void add() {
		System.out.println("dept--add");
	}

	@Override
	public void update() {
		System.out.println("dept--update");
	}
	
}

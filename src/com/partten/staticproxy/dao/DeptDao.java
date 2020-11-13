package com.partten.staticproxy.dao;

public class DeptDao implements Dao{

	@Override
	public void add() {
		System.out.println("dept--add");
	}
	
}

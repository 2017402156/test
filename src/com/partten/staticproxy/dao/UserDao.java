package com.partten.staticproxy.dao;

public class UserDao implements Dao{

	@Override
	public void add() {
		System.out.println("user--add");
	}
	
}
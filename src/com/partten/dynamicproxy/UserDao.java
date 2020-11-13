package com.partten.dynamicproxy;

public class UserDao implements Dao{

	@Override
	public void add() {
		System.out.println("user--add");
	}
	@Override
	public void update() {
		System.out.println("user--update");
	}
}
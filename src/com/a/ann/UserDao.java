package com.a.ann;

public class UserDao {

	@MyTransaction
	public void insert() {
		System.out.println("增加一个user");
	}
	
	@MyTransaction(value=TransactionEnumType.close)
	public void query() {
		System.out.println("查询一个user");
	}
	
}

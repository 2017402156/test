package com.a.ann;

public class UserDao {

	@MyTransaction
	public void insert() {
		System.out.println("����һ��user");
	}
	
	@MyTransaction(value=TransactionEnumType.close)
	public void query() {
		System.out.println("��ѯһ��user");
	}
	
}

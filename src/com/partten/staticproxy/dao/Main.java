package com.partten.staticproxy.dao;
//需求？我希望这个世界简单一点，一个代码到处用，不要每个代码都去改
public class Main {

	public static void main(String[] args) {
		//在每个具体dao执行add方法前，增加一个    “这是add方法”   的提示
		Dao dao=new ProxyDao().getProxyDao("user");
		System.out.println(dao.getClass().getSimpleName());
		dao.add();
		
		Dao dao2=new ProxyDao().getProxyDao("dept");
		System.out.println(dao2.getClass().getSimpleName());
		dao2.add();
	}
	
}
//静态代理方式
class ProxyDao{
	
	public Dao getProxyDao(String dao) {
		if(dao.equals("user")) {
			return new UserDao() {
				public void add() {
					System.out.println("这是add方法");
					System.out.println("user--add");
				}
			};
		}else if(dao.equals("dept")) {
			return new DeptDao() {
				public void add() {
					System.out.println("这是add方法");
					System.out.println("dept--add");
				}
			};
		}
		return null;
	}
	
	
}
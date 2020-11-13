package com.partten.staticproxy.dao;
//������ϣ����������һ�㣬һ�����뵽���ã���Ҫÿ�����붼ȥ��
public class Main {

	public static void main(String[] args) {
		//��ÿ������daoִ��add����ǰ������һ��    ������add������   ����ʾ
		Dao dao=new ProxyDao().getProxyDao("user");
		System.out.println(dao.getClass().getSimpleName());
		dao.add();
		
		Dao dao2=new ProxyDao().getProxyDao("dept");
		System.out.println(dao2.getClass().getSimpleName());
		dao2.add();
	}
	
}
//��̬����ʽ
class ProxyDao{
	
	public Dao getProxyDao(String dao) {
		if(dao.equals("user")) {
			return new UserDao() {
				public void add() {
					System.out.println("����add����");
					System.out.println("user--add");
				}
			};
		}else if(dao.equals("dept")) {
			return new DeptDao() {
				public void add() {
					System.out.println("����add����");
					System.out.println("dept--add");
				}
			};
		}
		return null;
	}
	
	
}
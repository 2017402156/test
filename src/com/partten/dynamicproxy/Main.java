package com.partten.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

	public static void main(String[] args) {
		//��ÿ������daoִ��add����ǰ������һ��    ������add������   ����ʾ
		Dao dao=new UserDao();
		dao=new DeptDao();
		dao=new DaoProxy().getProxyDao(dao);
		dao.add();
		dao.update();
	}
	
}
class DaoProxy{
	
	/**
	 * @param dao
	 * ��̬����������÷���ʱ��ͨ��jvm�ҵ��趨�ķ������ģ�壬����ģ���滻��ԭָ�����������
	 * ִ�е�ʱ���Ե���ģ����߼�Ϊ��Ҫ�߼�
	 */
	public Dao getProxyDao(Dao dao) {
		
		//��̬�����࣬����һ����̬�����ʵ��
		//classloader-dao����������װ��  interfaces-�Ҹ�ģ���  invocationhandler--���帲��ģ��
		//�õ����ӵĻ�ױ��
		ClassLoader classLoader=dao.getClass().getClassLoader();
		//�ұ��ӵ�����   �����  ������
		Class[] interfaces= {Dao.class};
		//����İ�װ���ӵ�˵������
		String preStr="����һ��"+dao.getClass().getSimpleName()+"��add����";
		
		InvocationHandler ihandler=new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				if(method.getName().equals("add")) {
					System.out.println(preStr);
				}
				
				return method.invoke(dao,args);
			}
		};
		
		return (Dao) Proxy.newProxyInstance(classLoader, interfaces,ihandler);
	}
	
}
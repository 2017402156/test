package com.partten.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

	public static void main(String[] args) {
		//在每个具体dao执行add方法前，增加一个    “这是add方法”   的提示
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
	 * 动态代理，对象调用方法时，通过jvm找到设定的方法替代模板，将该模板替换进原指定方法代码块
	 * 执行的时候，以调用模板的逻辑为主要逻辑
	 */
	public Dao getProxyDao(Dao dao) {
		
		//动态代理类，创建一个动态代理的实例
		//classloader-dao的子类孕育装备  interfaces-找个模板改  invocationhandler--具体覆盖模板
		//拿到鼻子的化妆间
		ClassLoader classLoader=dao.getClass().getClassLoader();
		//找鼻子的类型   猪鼻子  狗鼻子
		Class[] interfaces= {Dao.class};
		//具体的安装鼻子的说明步骤
		String preStr="这是一个"+dao.getClass().getSimpleName()+"的add方法";
		
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
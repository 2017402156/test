package com.a.ann;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
//注解
public class Demo {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
		UserDao dao=new UserDao();
		//1，识别注解--反射
		Class clazz=dao.getClass();
		Method method=clazz.getDeclaredMethod("insert");
		MyTransaction ann=method.getDeclaredAnnotation(MyTransaction.class);
		if(ann.value().equals(TransactionEnumType.open)) {
			//开启事物
			System.out.println("开启事务");
			dao.insert();
			System.out.println("关闭事务");
		}
		
	}
	
}
class Fu{
	public void fuMethod() {
		System.out.println("父方法");
	}
}
class Son extends Fu{
	@Override
	public void fuMethod() {
		System.out.println("子方法");
		List list=new ArrayList();
	}
}
@interface MyAnn{//annotation
	//注解是一种特殊的java类型，用于替代xml配置文件
}
//注解的定义位置
@MyAnn
class MyTest{
	@MyAnn
	private int age;
	@MyAnn
	public MyTest() {}
	@MyAnn
	public void metho1(@MyAnn String name) {
		@MyAnn
		int temp=0;
	}
}
//注解的属性
@interface MyAnn1{
	//注解的属性
	String value();
	int value1();
	String[] value2();
//	Dog dogValue();
//	Dog[] value3();
	季节 value4();
	季节[] value5();
}
@interface MyAnn2{
	String value();
}
@interface MyAnn3{
	String value2();
	季节[] value();
}
enum 季节{
	春,夏,秋,冬;
}
@MyAnn3(value2="",value={季节.春,季节.夏})
@MyAnn2(value="田园dog")
class Dog{
	@MyAnn2("田狗")//---仅仅针对属性值是value这个具体的拼写
	private String type;
	
}

@interface MyAnn4{
	String value2() default "狗子爱骨头";
	季节[] value();
}
@MyAnn4(value= {季节.冬,季节.夏})
class DogPlus{
	
	@MyAnn4({季节.冬,季节.夏,季节.秋})
	private String life;
	
}

@Target(value = {ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@interface MyAnn5{
	
}

@MyAnn5
class DogPlus2{
	@MyAnn5
	private int age;
	@MyAnn5
	private void show() {
		
	}
}



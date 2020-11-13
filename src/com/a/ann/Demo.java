package com.a.ann;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
//ע��
public class Demo {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
		UserDao dao=new UserDao();
		//1��ʶ��ע��--����
		Class clazz=dao.getClass();
		Method method=clazz.getDeclaredMethod("insert");
		MyTransaction ann=method.getDeclaredAnnotation(MyTransaction.class);
		if(ann.value().equals(TransactionEnumType.open)) {
			//��������
			System.out.println("��������");
			dao.insert();
			System.out.println("�ر�����");
		}
		
	}
	
}
class Fu{
	public void fuMethod() {
		System.out.println("������");
	}
}
class Son extends Fu{
	@Override
	public void fuMethod() {
		System.out.println("�ӷ���");
		List list=new ArrayList();
	}
}
@interface MyAnn{//annotation
	//ע����һ�������java���ͣ��������xml�����ļ�
}
//ע��Ķ���λ��
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
//ע�������
@interface MyAnn1{
	//ע�������
	String value();
	int value1();
	String[] value2();
//	Dog dogValue();
//	Dog[] value3();
	���� value4();
	����[] value5();
}
@interface MyAnn2{
	String value();
}
@interface MyAnn3{
	String value2();
	����[] value();
}
enum ����{
	��,��,��,��;
}
@MyAnn3(value2="",value={����.��,����.��})
@MyAnn2(value="��԰dog")
class Dog{
	@MyAnn2("�ﹷ")//---�����������ֵ��value��������ƴд
	private String type;
	
}

@interface MyAnn4{
	String value2() default "���Ӱ���ͷ";
	����[] value();
}
@MyAnn4(value= {����.��,����.��})
class DogPlus{
	
	@MyAnn4({����.��,����.��,����.��})
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



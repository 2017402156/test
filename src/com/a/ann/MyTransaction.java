package com.a.ann;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//ע�ⱻ������ʶ����
//���Ǳ�.class�ļ�����ʱʶ���أ�
//���Ǳ�java����ʶ��ѽ��

//�����ļ��ܹ���java����ʱ��ʶ��
@Retention(value = RetentionPolicy.RUNTIME)
//�������ܹ����õ�������
@Target(value= {ElementType.METHOD})
public @interface MyTransaction {
	TransactionEnumType value() default TransactionEnumType.open;
}

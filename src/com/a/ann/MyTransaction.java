package com.a.ann;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注解被编译器识别吗？
//还是被.class文件运行时识别呢？
//或是被java代码识别呀？

//配置文件能够在java运行时候被识别
@Retention(value = RetentionPolicy.RUNTIME)
//该配置能够作用到方法上
@Target(value= {ElementType.METHOD})
public @interface MyTransaction {
	TransactionEnumType value() default TransactionEnumType.open;
}

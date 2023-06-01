package com.spring.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student1 = ctx.getBean("student", Student.class);		
		Student student2 = ctx.getBean("student", Student.class);
		student2.setName("햅번");
		
		System.out.println("==============================");
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		System.out.println("==============================");
		System.out.println("이름 : " + student2.getName());
		System.out.println("나이 : " + student2.getAge());
		System.out.println("==============================");

		if(student1.equals(student2)) {
			System.out.println("scope=singletone, student1 == student2");
		} else {
			System.out.println("scope=singletone, student1 != student2");
		}


// prototype 사용	
		Student act1 = ctx.getBean("act", Student.class);
		Student act2 = ctx.getBean("act", Student.class);
		act2.setName("앤 헤서웨어");
		act2.setAge(32);

		System.out.println("==============================");	
		System.out.println("이름 : " + act1.getName());
		System.out.println("나이 : " + act1.getAge());
		System.out.println("==============================");	
		System.out.println("이름 : " + act2.getName());
		System.out.println("나이 : " + act2.getAge());
		System.out.println("==============================");			
		
		if(act1.equals(act2)) {
			System.out.println("scope=prototype, act1 == act2");
		} else {
			System.out.println("scope=prototype, act1 != act2");
		}
		
		ctx.close();
		
	}
	
}

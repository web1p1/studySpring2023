package com.spring.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student1 = ctx.getBean("student", Student.class);
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		
		System.out.println("==============================");
		
		Student student2 = ctx.getBean("student", Student.class);
		student2.setName("햅번");
		// student2.setAge(29);
		
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		
		System.out.println("==============================");

		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		} else {
			System.out.println("student1 != student2");
		}

//		Student person1 = student2;
//		Student person2 = ctx.getBean("student2", Student.class);
//		if(person1.equals(person2)) {
//			System.out.println("같은 Bean");
//		} else {
//			System.out.println("다른 Bean");
//		}

// prototype 사용		
		Student act1 = ctx.getBean("act1", Student.class);
		Student act2 = ctx.getBean("act2", Student.class);

		System.out.println("==============================");	
		System.out.println("이름 : " + act1.getName());
		System.out.println("나이 : " + act1.getAge());
		System.out.println("==============================");	
		System.out.println("이름 : " + act2.getName());
		System.out.println("나이 : " + act2.getAge());
		System.out.println("==============================");			
		
		ctx.close();
		
	}
	
}

package com.spring.ex;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");

// 위의 과정을 2 단계(생성 + 설정)로 나눔
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();	// 생성
		ctx.load("classpath:applicationCTX.xml");	// 설정

		Student student = ctx.getBean("student", Student.class);	// 사용
		System.out.println("이름 : " + student.getName());
		System.out.println("나이 : " + student.getAge());
		
		ctx.close();															// 종료
		
	}
	
}

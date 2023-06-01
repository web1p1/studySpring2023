package com.spring.ex;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();	// 스프링 컨테이너 생성

		ctx.load("classpath:applicationCTX.xml"); // 스프링 컨테이너 설정
		
		ctx.refresh(); // 스프링 컨테이너 설정
		
		ctx.close(); // 스프링 컨테이너 종료
		
	}
	
}

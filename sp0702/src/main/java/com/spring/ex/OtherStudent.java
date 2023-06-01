package com.spring.ex;

import javax.annotation.*;

public class OtherStudent  {

	private String name;
	private int age;
	
	public OtherStudent(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	@SuppressWarnings("restriction")
	@PostConstruct  // 별도 dependency 
	public void initMethod() {
		System.out.println("initMethod()");
	}
	
	@SuppressWarnings("restriction")
	@PreDestroy
	public void destroyMethod() {
		System.out.println("destroyMethod()");
	}

}

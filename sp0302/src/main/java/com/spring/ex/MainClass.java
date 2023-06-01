package com.spring.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
	/*	
		MyCalculator myCalculator = new MyCalculator();
		myCalculator.setCalculator(new Calculator());

		myCalculator.setFirstNum(10);
		myCalculator.setSecondNum(2);
	*/
		String configLocation = "classpath:applicationCTX.xml";

		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);
		ctx.close();

		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
	}

}

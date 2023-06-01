package com.spring.ex;

public class Calculator {
	
/*
	private int firstNum;
	private int secondNum;
	
	public int getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public int getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
*/	
	
	public void addition(int firstNum, int secondNum) {
		System.out.println("addition()");
		int result = firstNum + secondNum;
		System.out.println(firstNum + " + " + secondNum + " = " + result);
	}
	
	public void subtraction(int firstNum, int secondNum) {
		System.out.println("subtraction()");
		int result = firstNum - secondNum;
		System.out.println(firstNum + " - " + secondNum + " = " + result);
	}
	
	public void multiplication(int firstNum, int secondNum) {
		System.out.println("multiplication()");
		int result = firstNum * secondNum;
		System.out.println(firstNum + " * " + secondNum + " = " + result);
	}
	
	public void division(int firstNum, int secondNum) {
		System.out.println("division()");
		int result = firstNum / secondNum;
		System.out.println(firstNum + " / " + secondNum + " = " + result);
	}

}

package com.spring.ex;

public class BmiCalculator {

	private double normal;
	private double over_weight;
	private double obesity;
	
	public void bmi_calculator(double weight, double height) {
		
		double h = height * 0.01;
		double result = weight / (h*h);
		
		System.out.println("BMI지수 : " + (int)result);
		
		if(result>obesity) {
			System.out.println("비만 ... 응급, 10일 금식");
		} else if (result > over_weight) {
			System.out.println("과체중 ... 주의, 3일 금식");
		} else if (result > normal) {
			System.out.println("정상 ... 잘 관리하셨군요");
		} else {
			System.out.println("저체중 ... 많이 드셔도 됩니다");
		}
	}

	public void setLow_weight(double low_weight) {
	}

	public void setNormal(double normal) {
		this.normal = normal;
	}

	public void setOver_weight(double over_weight) {
		this.over_weight = over_weight;
	}

	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
}

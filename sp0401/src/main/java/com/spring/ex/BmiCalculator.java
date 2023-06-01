package com.spring.ex;

public class BmiCalculator {

	private double normal;
	private double over_weight;
	private double obesity;
	
	public void bmi_calculator(double weight, double height) {
		
		double h = height * 0.01;
		double result = weight / (h*h);
		
		System.out.println("BMI���� : " + (int)result);
		
		if(result>obesity) {
			System.out.println("�� ... ����, 10�� �ݽ�");
		} else if (result > over_weight) {
			System.out.println("��ü�� ... ����, 3�� �ݽ�");
		} else if (result > normal) {
			System.out.println("���� ... �� �����ϼ̱���");
		} else {
			System.out.println("��ü�� ... ���� ��ŵ� �˴ϴ�");
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

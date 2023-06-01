package com.spring.ex;

public class StudentInfo {

	private Student student;
	
	public StudentInfo(Student student) {
		this.student = student;
	}
	
	public void getStudentInfo(){
		if(student != null) {
			System.out.println("NAME  : " + student.getName());
			System.out.println("AGE   : " + student.getAge());
			System.out.println("GRADE : " + student.getGradeNum());
			System.out.println("CLASS : " + student.getClassNum());
			System.out.println("======================");
		}
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
}

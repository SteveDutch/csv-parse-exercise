package com.coderscampus.assignment4;

public class StudentService {
	
	public void correctStudentCourseAndGrade(Student student) {
		String extractGrade = student.getCourse().replaceAll("[^0-9]", "");
		Float correctGrade = Float.parseFloat(extractGrade) + student.getGrade() / 100;
		student.setGrade(correctGrade);
		
	}

}

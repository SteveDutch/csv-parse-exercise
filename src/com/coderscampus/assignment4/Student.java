package com.coderscampus.assignment4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Student implements Comparable<Student> {

	private Integer studentID = null;
	private String studentName = null;
	private String course = null;
	private Float grade = null;

	public Student(Integer studentID, String studentNanme, String course, Float grade) {

		this.studentID = studentID;
		this.studentName = studentNanme;
		this.course = course;
		this.grade = grade;
	}

	public Student(String[] array) {
		this.studentID = Integer.parseInt(array[0]);
		this.studentName = array[1];
		this.course = array[2];
		this.grade = Float.parseFloat(array[3]);
	}

// setter & getter 
	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentNanme(String studentName) {
		this.studentName = studentName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Float getGrade() {
		return grade;
	}

	public void setGrade(Float grade) {
		this.grade = grade;
	}

	// thanks to
//	https://stackoverflow.com/questions/1903252/extract-integer-part-in-string#1903649
//	for the regex part	
	public void correctStudentCourseAndGrade() {
		// returns digits
		String extractGrade = getCourse().replaceAll("[^0-9]", "");
		Float oldGrade = getGrade();
		Float correctGrade = oldGrade / 100 + Float.parseFloat(extractGrade);
		setGrade(correctGrade);

		String correctCourse = getCourse();
		// cuts off digits, returns new string
		correctCourse = correctCourse.replaceAll("\\d", "");
		setCourse(correctCourse);

	}

	@Override
	public int compareTo(Student that) {
		if (that.getGrade() == null) {
			return -1;
		}
		return that.getGrade().compareTo(this.getGrade());

	}

	public void saveCourse(String outputFile1) throws IOException {
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(outputFile1, true));

			writer.write("\n" + Integer.toString(studentID) + ",");
			writer.write(studentName + ",");
<<<<<<< HEAD
			writer.write(course + ",");
=======
			writer.write(course +",");
>>>>>>> 855c745795217899f9771c1cb7822428d87754b3
			writer.write(Float.toString(grade));
		} finally {
			if (writer != null)
				writer.close();
		}

	}

	public void makeFile(String outputFile1) throws IOException {
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(outputFile1, false));
			writer.write("Student ID,Student Name,Course,Grade");
		} finally {
			if (writer != null)
				writer.close();
		}

	}

}

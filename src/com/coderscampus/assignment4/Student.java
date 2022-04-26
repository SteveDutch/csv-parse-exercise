package com.coderscampus.assignment4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Student implements Comparable<Student> {

	private Integer studentID = null;
	private String studentName = null;
	private String course = null;
	private Integer grade = null;

	public Student(Integer studentID, String studentNanme, String course, Integer grade) {

		this.studentID = studentID;
		this.studentName = studentNanme;
		this.course = course;
		this.grade = grade;
	}

	public Student(String[] array) {
		this.studentID = Integer.parseInt(array[0]);
		this.studentName = array[1];
		this.course = array[2];
		this.grade = Integer.parseInt(array[3]);
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

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	// thanks to
//	https://stackoverflow.com/questions/1903252/extract-integer-part-in-string#1903649
//	for the regex part	
	/*  --> unnesserary since grade is just an integer 
	 * 
	 *Z(and it's course = COMPSCI 310 & grade = 99 intead of courser = COMPSCI & grade = 310,99)
	 * 
	 * public void correctStudentCourseAndGrade() { // returns digits String
	 * extractGrade = getCourse().replaceAll("[^0-9]", ""); Float oldGrade =
	 * getGrade(); Float correctGrade = oldGrade / 100 +
	 * Float.parseFloat(extractGrade); setGrade(correctGrade);
	 * 
	 * String correctCourse = getCourse(); // cuts off digits, returns new string
	 * correctCourse = correctCourse.replaceAll("\\d", "");
	 * setCourse(correctCourse);
	 * 
	 * }
	 */

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
			writer.write(course + ",");
			writer.write(Integer.toString(grade));
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

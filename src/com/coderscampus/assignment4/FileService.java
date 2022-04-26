package com.coderscampus.assignment4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FileService {

	public FileService(String filename) throws IOException {

		BufferedReader fileReader = null;
		BufferedReader fileReader2 = null;

		// Studentenzählschleife,counting loop for enrolled student per course
		// to get the array size
		Integer count1 = 0;
		Integer count2 = 0;
		Integer count3 = 0;

		try {
			fileReader = new BufferedReader(new FileReader(filename));

			String line = "";
			while ((line = fileReader.readLine()) != null) {
				if (line.contains("COMPSCI")) {
					count1++;

				} else if (line.contains("APMTH")) {
					count2++;
				} else if (line.contains("STAT")) {
					count3++;
				}

			}

		} finally {

			fileReader.close();
		}
		// split into courses
		Student[] course1 = new Student[count1];
		Student[] course2 = new Student[count2];
		Student[] course3 = new Student[count3];
		try {
			fileReader2 = new BufferedReader(new FileReader(filename));

			String line = "";
			int i = 0;
			int j = 0;
			int k = 0;
			while ((line = fileReader2.readLine()) != null) {
				// TODO vermutlich kann ich aus den drei Blöcken eine Methode machen...
				if (line.contains("COMPSCI")) {

					String[] enrolledStudent = line.split(",");
					course1[i] = new Student(enrolledStudent);
					// course1[i].correctStudentCourseAndGrade();
					i++;

				} else if (line.contains("APMTH")) {
					String[] enrolledStudent = line.split(",");
					course2[j] = new Student(enrolledStudent);
					// course2[j].correctStudentCourseAndGrade();
					j++;
				} else if (line.contains("STAT")) {
					String[] enrolledStudent = line.split(",");
					course3[k] = new Student(enrolledStudent);
					// course3[k].correctStudentCourseAndGrade();
					k++;
				}

			}

		} finally {

		fileReader2.close();
		}

		// sortieren - sort, incl handling of a potential null value
		Arrays.sort(course1, Comparator.nullsLast(Comparator.naturalOrder()));
		Arrays.sort(course2, Comparator.nullsLast(Comparator.naturalOrder()));
		Arrays.sort(course3, Comparator.nullsLast(Comparator.naturalOrder()));

		course1[0].makeFile("course1.csv");
		for (Student student : course1) {
			student.saveCourse("course1.csv");
		}

		course2[0].makeFile("course2.csv");
		for (Student student : course2) {
			student.saveCourse("course2.csv");
		}

		course3[0].makeFile("course3.csv");
		for (Student student : course3) {
			student.saveCourse("course3.csv");
		}

	}

}

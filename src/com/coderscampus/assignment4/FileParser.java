package com.coderscampus.assignment4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileParser {
	

	public FileParser (String filename) throws IOException {
		System.out.println("FileParser evoked");
		BufferedReader fileReader = null;
		BufferedReader fileReader2 = null;
		
		//Zählschleife,counting loop for enrolled student per course 
		//to get the array size
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
				System.out.print(line);

				
			}
			
		} finally {
			System.out.println("\nClosing file reader");
			System.out.println(count1);
			System.out.println(count2);
			System.out.println(count3);
			fileReader.close();
		}
		// split into courses
		Student[] course1 = new Student[count1];
		Student[] course2 = new Student[count2];
		Student[] course3 = new Student[count3];
		try { 
			fileReader2 = new BufferedReader(new FileReader(filename));
			System.out.println("filereader2 evoked");
			String line = "";
			int i = 0;
			int j = 0;
			int k = 0;
			while ((line = fileReader2.readLine()) != null) {
				// TODO vermutlich kann ich aus den drei Blöcken eine Methode machen...
				if (line.contains("COMPSCI")) {
					
					String[] enrolledStudent = line.split(",");
					course1[i] = new Student(enrolledStudent);
					course1[i].correctStudentCourseAndGrade();
					//System.out.println(enrolledStudent);
					i++;
					System.out.println(course1[i-1]);
				} else if (line.contains("APMTH")) {
					String[] enrolledStudent = line.split(",");
					course2[j] = new Student(enrolledStudent);
					course2[j].correctStudentCourseAndGrade();
					//System.out.println(enrolledStudent);
					j++;
				} else if (line.contains("STAT")) {
					String[] enrolledStudent = line.split(",");
					course3[k] = new Student(enrolledStudent);
					course3[k].correctStudentCourseAndGrade();
					//System.out.println(enrolledStudent);
					k++;
				}
//				System.out.print(line);

				
			}
			
		} finally {
			System.out.println("\nClosing file reader No 2");
			System.out.println(count1);
			System.out.println(count2);
			System.out.println(count3);
			fileReader2.close();
		}
		
		// zeige reihenfolge vorm sortieren
		for (Student student : course1) {
			System.out.println(student.getGrade());
		}
		// sortieren
		Arrays.sort(course1);
		// zeige reihenfolge nachm sortieren
		System.out.println("_______________________");
		for (Student student : course1) {
			System.out.println(student.getGrade());
		}
	}


	
	

}

package com.coderscampus.assignment4;

public class StudentService extends Student {
	
	public StudentService(String[] array) {
		super(array);
		// TODO Auto-generated constructor stub
	}

	public void correctStudentCourseAndGrade(Student student) {
		String extractGrade = student.getCourse().replaceAll("[^0-9]", "");
		Float correctGrade = Float.parseFloat(extractGrade) + student.getGrade() / 100;
		student.setGrade(correctGrade);
		System.out.println("is this used?");
	}
	
//	public void checkForNullValue(Student[] courseList) {
//		for (Student student : courseList) {
//
//			if (student.equals(null)) {
//				System.out.println("Oopsi, here's a NULL value :o");
//				break;
//			}
//		}
	}
//}
	
//	public void  saveCourse(Student student) throws IOException {
//			
//			
//		BufferedWriter writer = null;
//		System.out.println("writer evoked");
//	
//		try {
//		writer = new BufferedWriter(new FileWriter(outputFile));
//		writer.write(outputFile);
//		writer.write("Is this line of text on a new line?");
//		} finally {
//			if (writer != null) writer.close();
//		}
//
//	}
//
//}

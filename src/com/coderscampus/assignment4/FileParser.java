package com.coderscampus.assignment4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
	

	public FileParser (String filename) throws IOException {
		System.out.println("FileParser evoked");
		BufferedReader fileReader = null;
//		final String filename = "student-master-list.csv";	

		try { 
			fileReader = new BufferedReader(new FileReader(filename));
			
			String line = "";
			while ((line = fileReader.readLine()) != null) {
				System.out.println(line);
			}
			
		} finally {
			System.out.println("Closing file reader");
			fileReader.close();
		}
	}

}

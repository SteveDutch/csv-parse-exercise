package com.coderscampus.assignment4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileSerrvice {
	
		
		public String  write(String outputFile) throws IOException {
			BufferedWriter writer = null;
			System.out.println("writer evoked");
		
			try {
			writer = new BufferedWriter(new FileWriter(outputFile));
			writer.write("This is a test string that will be output into a file.\n");
			writer.write("Is this line of text on a new line?");
			} finally {
				if (writer != null) writer.close();
			}
			String temp = "under construction";
			return temp;
		}
		
}
	
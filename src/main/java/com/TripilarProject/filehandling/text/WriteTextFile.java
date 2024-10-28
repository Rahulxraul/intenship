package com.TripilarProject.filehandling.text;

import java.io.FileWriter;
import java.io.IOException;

public class WriteTextFile {
	 public void writeToFile(String filename, String content) {
	        try {
	            FileWriter writer = new FileWriter(filename);
	            writer.write(content);
	            writer.close();
	            System.out.println("Successfully written to the file.");
	        } catch (IOException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
}
}

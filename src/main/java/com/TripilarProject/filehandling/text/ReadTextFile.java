package com.TripilarProject.filehandling.text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTextFile {
	 public void readFromFile(String filename) {
	        try {
	            File file = new File(filename);
	            Scanner reader = new Scanner(file);
	            while (reader.hasNextLine()) {
	                String data = reader.nextLine();
	                System.out.println(data);
	            }
	            reader.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
	    }
	}


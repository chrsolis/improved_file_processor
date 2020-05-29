package com.bnet.fileprocessor.logic;

import java.util.Scanner;
import java.io.FileNotFoundException;

import com.bnet.fileprocessor.finout.FileContent;
import com.bnet.fileprocessor.finout.InputFileHandler;

public class Run {
	public static void main (String [] args) {
		// testInputFileHandler();
		testFileContent();
	}
	
	public static void testInputFileHandler() {
		Scanner uIn = new Scanner(System.in);
		String response = "";
		
		boolean validFile = true;
		
		do {
			validFile = true;
			System.out.print("Please enter the path of your file: ");
			response = uIn.nextLine();
			
			try {
				InputFileHandler inFile = new InputFileHandler(response);
			} catch (FileNotFoundException fnfExc) {
				validFile = false;
				System.out.println("The file path provided does not exist.");
			}
		} while (!validFile);
	}
	
	public static int testFileContent() {
		String testFilePath = "D:/test.txt";
		InputFileHandler inFile;
		try {			
			inFile = new InputFileHandler(testFilePath);
		} catch (FileNotFoundException fnfExc) {
			System.out.println("The file path provided does not exist.");
			return -1;
		}
		
		FileContent fContent = inFile.processFile();
		System.out.println(fContent.getRecordByIndex(0).toString());
		return 0;
	}
}
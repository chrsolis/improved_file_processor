package com.bnet.fileprocessor.finout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputFileHandler {
	File inputFile;
	BufferedReader inFileReader;
	
	public InputFileHandler(File in) throws FileNotFoundException {
		inputFile = in;
		if (!inputFile.exists()) throw new FileNotFoundException();
		
		inFileReader = new BufferedReader(new FileReader(inputFile));
	}
	
	public InputFileHandler(String fPath) throws FileNotFoundException {
		inputFile = new File(fPath);
		if (!inputFile.exists()) throw new FileNotFoundException();
		
		inFileReader = new BufferedReader(new FileReader(inputFile));
	}
	
	public FileContent processFile() {
		FileContent fContent = new FileContent();
		
		try {
			/* Get rid of the first line, as it only has column titles and no data. */
			inFileReader.readLine();
			
			String rawRecord = "";
			
			while ((rawRecord = inFileReader.readLine()) != null) {
				fContent.insertRecord(rawRecord);
			}
			
			return fContent;
		} catch(IOException ioExc) {
			System.out.println("\nIOException -- Did the file change directory or permissions?");
			return null;
		} 
	}
}

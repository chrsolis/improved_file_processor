package com.bnet.fileprocessor.logic;

import java.io.FileNotFoundException;
import java.io.File;

import com.bnet.fileprocessor.finout.FileContent;
import com.bnet.fileprocessor.finout.InputFileHandler;
import com.bnet.fileprocessor.finout.OutputFileHandler;

public class Main {	
	private File inF;
	private File outF;
	private InputFileHandler inFile;
	private OutputFileHandler outFile;
	
	public Main(File in, File out) {
		inF = in;
		outF = out;
		
		try {			
			inFile = new InputFileHandler(inF);
			outFile = new OutputFileHandler(outF);
		} catch (FileNotFoundException fnfExc) {
			System.out.println("The file path provided does not exist.");
		}
	}
	
	public void run() {
		FileContent fContent = inFile.processFile();
		DataParsing dParser = new DataParsing(fContent);
		
		outFile.writeTotalsFile(dParser.getLocationDataArray());
	}
}
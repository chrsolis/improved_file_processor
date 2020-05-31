package com.bnet.fileprocessor.finout;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.bnet.fileprocessor.logic.LocationData;

public class OutputFileHandler {
	private File outputFile;
	private BufferedWriter outFileWriter;
	private String outFilePathDir;
	private int timesCalled;
	
	public OutputFileHandler(File out) {
		outputFile = out;
		timesCalled = 0;
		
		if (outputFile == null) {
			outFilePathDir = "";
		} else {
			outFilePathDir = outputFile.getAbsolutePath();
		}
	}
	
	public int writeTotalsFile(ArrayList<LocationData> locArr) {	
		try {			
			if (outputFile == null) {
				outputFile = new File("Totals-" + timesCalled + ".csv");
			} else {
				String newDir = outFilePathDir + "Totals-" + timesCalled + ".csv";
				System.out.println("newDir");
				outputFile = new File(newDir);
			}
			
			if (!outputFile.exists()) {
				outputFile.createNewFile();
			}
			
			outFileWriter = new BufferedWriter(new FileWriter(outputFile));
		} catch (IOException ioe) {
			// ERROR HANDLING
		}
		
		try {
			outFileWriter.write("Location,Calls,Seconds,Minutes,Total Price,Rate,Product");
			
			for (int i = 0; i < locArr.size(); i++) {
				outFileWriter.newLine();
				outFileWriter.write(locArr.get(i).getLocation() + "," + locArr.get(i).getRecordsFound() + "," + locArr.get(i).getDuration() + ","
						+ locArr.get(i).getMinutes() + "," + locArr.get(i).getTotalAmt() + "," + locArr.get(i).getRate() + ","
						+ locArr.get(i).getProduct());
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return -1;
		} finally {
			try {
				if (outFileWriter != null) {
					outFileWriter.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
				// HANDLE
			}
		}
		timesCalled++;
		System.out.println("Totals computed to: " + outFilePathDir);
		return 0;
	}
	
	public String getFilePath() {
		return outFilePathDir;
	}
}

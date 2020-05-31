package com.bnet.fileprocessor.finout;

import java.util.ArrayList;

public class FileContent {
	private ArrayList<RecordData> dataArray;
	
	public FileContent() {
		dataArray = new ArrayList<RecordData>();
	}
	
	public void insertRecord(String rawData) {		
		String [] rawDataFields = rawData.split(",");
		
		int accountId = Integer.parseInt(rawDataFields[0]);
		String ogTrunkGroup = rawDataFields[1];
		String mediaIp = rawDataFields[2];
		String callTime = rawDataFields[3];
		int duration = Integer.parseInt(rawDataFields[4]);
		String location = rawDataFields[5];
		String destNum = rawDataFields[6];
		String ani = rawDataFields[7];
		int dialCode = Integer.parseInt(rawDataFields[8]);
		String product = rawDataFields[9];
		double totalAmount = Double.parseDouble(rawDataFields[10]);
		int infoDigits = Integer.parseInt(rawDataFields[11]);
		String signalingIp = rawDataFields[12];
		
		RecordData newRecord = new RecordData(accountId, ogTrunkGroup, mediaIp, callTime, duration, location, 
				destNum, ani, dialCode, product, totalAmount, infoDigits, signalingIp);
		
		dataArray.add(newRecord);
	}
	
	public RecordData getRecordByIndex(int index) {
		if (index >= dataArray.size()) {
			return null;
		}
		return dataArray.get(index);
	}
	public ArrayList<RecordData> getRecordArray() {
		return dataArray;
	}
}

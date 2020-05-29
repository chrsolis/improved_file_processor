package com.bnet.fileprocessor.finout;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileContent {
	private ArrayList<RecordData> dataArray;
	private int recordCount;
	
	public FileContent() {
		dataArray = new ArrayList<RecordData>();
		recordCount = 0;
	}
	
	public void insertRecord(String rawData) {
		StringTokenizer tokenizer = new StringTokenizer(rawData, ",");
		int dataIndex = 0;
		
		int accountId = Integer.parseInt(tokenizer.nextToken());
		String ogTrunkGroup = tokenizer.nextToken();
		String mediaIp = tokenizer.nextToken();
		String callTime = tokenizer.nextToken();
		int duration = Integer.parseInt(tokenizer.nextToken());
		String location = tokenizer.nextToken();
		String destNum = tokenizer.nextToken();
		String ani = tokenizer.nextToken();
		int dialCode = Integer.parseInt(tokenizer.nextToken());
		String product = tokenizer.nextToken();
		double totalAmount = Double.parseDouble(tokenizer.nextToken());
		int infoDigits = Integer.parseInt(tokenizer.nextToken());
		String signalingIp = tokenizer.nextToken();
		
		RecordData newRecord = new RecordData(accountId, ogTrunkGroup, mediaIp, callTime, duration, location, 
				destNum, ani, dialCode, product, totalAmount, infoDigits, signalingIp);
		
		dataArray.add(newRecord);
	}
	
	public RecordData getRecordByIndex(int index) {
		if (index > dataArray.size()) {
			return null;
		}
		return dataArray.get(index);
	}
}

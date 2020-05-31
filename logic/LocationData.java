package com.bnet.fileprocessor.logic;

public class LocationData {
	private String location;
	private int duration;
	private double totalAmt;
	private String product;
	private int recordsFound;
	
	public LocationData(String loc, int iDur, double iTotalAmt, String iProd) {
		location = loc;
		duration = iDur;
		totalAmt = iTotalAmt;
		product = iProd;
		recordsFound = 1;
	}
	
	public String getLocation() {
		return location;
	}
	public int getDuration() {
		return duration;
	}
	public double getTotalAmt() {
		return totalAmt;
	}
	public String getProduct() {
		return product;
	}
	public int getRecordsFound() {
		return recordsFound;
	}
	public double getMinutes() {
		return duration / 60.0;
	}
	public double getRate() {
		return totalAmt / getMinutes();
	}
	
	public void addRecordInfo(int dur, double tAmt, String prod) {
		recordsFound++;
		duration += dur;
		totalAmt += tAmt;
	}
}

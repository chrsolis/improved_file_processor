package com.bnet.fileprocessor.finout;

public class RecordData {
	private int accountId;
	private String ogTrunkGroup;
	private String mediaIp;
	private String callTime;
	private int duration;
	private String location;
	private String destNum;
	private String ani;
	private int dialCode;
	private String product;
	private double totalAmount;
	private int infoDigits;
	private String signalingIp;
	
	public RecordData(int aId, String ogTrGr, String medIp, String cTime, int dur, String loc,
			String dNum, String a, int dCode, String prod, double tAmt, int iDigits, String sIp) {
		accountId = aId;
		ogTrunkGroup = ogTrGr;
		mediaIp = medIp;
		callTime = cTime;
		duration = dur;
		location = loc;
		destNum = dNum;
		ani = a;
		dialCode = dCode;
		product = prod;
		totalAmount = tAmt;
		infoDigits = iDigits;
		signalingIp = sIp;
	}
	
	public String toString() {
		return "[ RECORD DATA TOSTRING INFORMATION ]\n"
			 + "-    AccountId: " + accountId + "\n"
			 + "- OgTrunkGroup: " + ogTrunkGroup + "\n"
			 + "-     Media IP: " + mediaIp + "\n"
			 + "-    Call Time: " + callTime + "\n"
			 + "-     Duration: " + duration + "\n"
			 + "-     Location: " + location + "\n"
			 + "-  Dest Number: " + destNum + "\n"
			 + "-          ANI: " + ani + "\n"
			 + "-    Dial Code: " + dialCode + "\n"
			 + "-      Product: " + product + "\n"
			 + "- Total Amount: " + totalAmount + "\n"
			 + "-  Info Digits: " + infoDigits + "\n"
			 + "- Signaling IP: " + signalingIp + "\n";
	}
	
	public int getAcctId() {
		return accountId;
	}
	public String getOgTrunkGroup() {
		return ogTrunkGroup;
	}
	public String getMediaIp() {
		return mediaIp;
	}
	public String getCallTime() {
		return callTime;
	}
	public int getDuration() {
		return duration;
	}
	public String getLocation() {
		return location;
	}
	public String getDestNum() {
		return destNum;
	}
	public String getAni() {
		return ani;
	}
	public int getDialCode() {
		return dialCode;
	}
	public String getProduct() {
		return product;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public int getInfoDigits() {
		return infoDigits;
	}
	public String getSignalingIp() {
		return signalingIp;
	}
	
	
}

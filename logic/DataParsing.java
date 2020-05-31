package com.bnet.fileprocessor.logic;

import java.util.ArrayList;

import com.bnet.fileprocessor.finout.FileContent;
import com.bnet.fileprocessor.finout.RecordData;

public class DataParsing {
	ArrayList<LocationData> locationsDataParsed;
	FileContent fContent;
	
	public DataParsing(FileContent file) {
		locationsDataParsed = new ArrayList<LocationData>();
		fContent = file;
		parseData();
		sortLocData();
	}
	
	public void printLocData() {
		for (int i = 0; i < locationsDataParsed.size(); i++) {
			System.out.println("[ LOCATION: " + locationsDataParsed.get(i).getLocation() + " ***** ]");
			System.out.println("- Duration: " + locationsDataParsed.get(i).getDuration());
			System.out.println("- TotalAmt: " + locationsDataParsed.get(i).getTotalAmt());
			System.out.println("-  Product: " + locationsDataParsed.get(i).getProduct());
			System.out.println("- Recs Fnd: " + locationsDataParsed.get(i).getRecordsFound());
			System.out.println("- - - - - - - - - - - -");
			System.out.println("-  Minutes: " + locationsDataParsed.get(i).getMinutes());
			System.out.println("-    Rates: " + locationsDataParsed.get(i).getRate());
			System.out.println("[      END  " + locationsDataParsed.get(i).getLocation() + " ***** ]\n");
		}
	}
	
	private void parseData() {
		ArrayList<RecordData> recordArray = fContent.getRecordArray();
				
		for (int i = 0; i < recordArray.size(); i++) {
			int locIndex = locationExists(recordArray.get(i).getLocation(), recordArray.get(i).getProduct());
			RecordData tRec = recordArray.get(i);
			if (locIndex == -1) {
				locationsDataParsed.add(new LocationData(tRec.getLocation(), tRec.getDuration(), tRec.getTotalAmount(), tRec.getProduct()));
			} else {
				locationsDataParsed.get(locIndex).addRecordInfo(tRec.getDuration(), tRec.getTotalAmount(), tRec.getProduct());
			}
		}
		
	}
	
	private int locationExists(String location, String product) {
		if (locationsDataParsed.size() == 0) {
			return -1;
		} else {
			for (int i = 0; i < locationsDataParsed.size(); i++) {
				if (locationsDataParsed.get(i).getLocation().equalsIgnoreCase(location) && locationsDataParsed.get(i).getProduct().equalsIgnoreCase(product)) {
					return i;
				}
			}
			return -1;
		}
	}
	
	public ArrayList<LocationData> getLocationDataArray() {
		return locationsDataParsed;
	}
	
	/* SORTING FUNCTIONS AND UTILITIES */
	private void sortLocData() {
		quickSort(locationsDataParsed, 0, locationsDataParsed.size() - 1);
	}
	
	private int partition(ArrayList<LocationData> arr, int low, int high) {
		String pivot = arr.get(high).getLocation();
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (arr.get(j).getLocation().compareToIgnoreCase(pivot) < 0) {
				i++;
				LocationData tmp = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j, tmp);
			}
		}
		LocationData tmp = arr.get(i + 1);
		arr.set(i + 1, arr.get(high));
		arr.set(high, tmp);
		
		return i + 1;
	}
	
	void quickSort(ArrayList<LocationData> arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			
			quickSort(arr, low, pi-1);
			quickSort(arr, pi+1, high);
		}
	}
}
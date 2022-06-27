package com.nagarro.javaassignment4.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.nagarro.javaassignment4.model.Tshirt;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvValidationException;

public class ReadCSVFiles {

	public static void  readCSVdata(final List<Tshirt> tshirts, String filename) throws IOException, CsvValidationException {
		
		
		CSVReaderHeaderAware csvReaderHeaderAware = new CSVReaderHeaderAware(new FileReader("C:/Users/yeswanthaddanki/git/yeswanth-sai-kumar-addanki/javaassignment1/csvdatafiles/"+filename));
		Map<String, String> values;
		Vector<Vector<String>> filedata = new Vector<Vector<String>>(); 
		
		while(((values = (Map<String,String>) csvReaderHeaderAware.readMap())) != null) {
			
			for(Map.Entry<String, String> entry: values.entrySet()) {
				
				String[] row = (entry.getValue()).split("\\|");   //"|" is pipeline in java and its tricky so use "\\|"
				Vector<String> rowdata = new Vector<String>(Arrays.asList(row));
				
				//filter data to make use of less memory
				
				filedata.addElement(rowdata);
				
			}
		}
		
		
		for (Vector<String> row : filedata) {
			
			Tshirt product = new Tshirt(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), Double.parseDouble(row.get(5)), Double.parseDouble(row.get(6)), row.get(7).charAt(0));
			
			tshirts.add(product);
		}
		
	}
	
}

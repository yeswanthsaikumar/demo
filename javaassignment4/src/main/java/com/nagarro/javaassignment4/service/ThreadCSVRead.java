package com.nagarro.javaassignment4.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.nagarro.javaassignment4.model.Tshirt;
import com.opencsv.exceptions.CsvValidationException;

public class ThreadCSVRead extends Thread{
	File[] files;
	final List<Tshirt> tshirts;
	
	
	public ThreadCSVRead(File[] files, final List<Tshirt> tshirts) {
		this.files = files;
		this.tshirts = tshirts;
	}
	
	
	public void run() {
		for (final File file : files) {
			try {
		
				ReadCSVFiles.readCSVdata(tshirts, file.getName());
			} catch (IOException e) {

				e.printStackTrace();
			} catch (CsvValidationException e) {
				
				e.printStackTrace();
			}
		}
	}
}
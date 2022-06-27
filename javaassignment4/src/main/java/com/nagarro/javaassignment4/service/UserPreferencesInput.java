package com.nagarro.javaassignment4.service;

public class UserPreferencesInput {
	private String colour;
	private String size;
	private String gender;
	private int outputpref;
	
	
	public UserPreferencesInput(String colour, String size, String gender, int outputpref) {
		
		this.colour = colour;
		this.size = size;
		this.gender = gender;
		this.outputpref = outputpref;
	}
	
	
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getoutputpref() {
		return outputpref;
	}
	public void setoutputpref(int outputpref) {
		this.outputpref = outputpref;
	}


	@Override
	public String toString() {
		return "UserPref [colour=" + colour + ", size=" + size + ", gender=" + gender + ", outputpref=" + outputpref
				+ "]";
	}
	
	
	
}
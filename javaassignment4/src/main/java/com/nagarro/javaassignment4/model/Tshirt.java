package com.nagarro.javaassignment4.model;

import javax.persistence.*;

@Entity
@Table(name = "tshirt")
public class Tshirt {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private Long id;
	
	@Column(name = "unum")
	private String unum;

	@Column(name = "name")
	private String name;

	@Column(name = "colour")
	private String colour;

	@Column(name = "genderrecommendation")
	private String genderRecommendation;

	@Column(name = "size")
	private String size;

	@Column(name = "price")
	private double price;

	@Column(name = "rating")
	private double rating;

	@Column(name = "availability")
	private char availability;

	public Tshirt() {

	}

	public Tshirt(String unum, String name, String colour, String gender, String size, double price,
			double rating, char availability) {

		this.unum = unum;
		this.name = name;
		this.colour = colour;
		this.genderRecommendation = gender;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.availability = availability;
	}

	public String getunum() {
		return unum;
	}

	public void setunum(String unum) {
		this.unum = unum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getGenderRecommendation() {
		return genderRecommendation;
	}

	public void setGenderRecommendation(String genderRecommendation) {
		this.genderRecommendation = genderRecommendation;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public char getAvailability() {
		return availability;
	}

	public void setAvailability(char availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "TShirt:{"+"Name:"+name+", colour:"+colour+" ,size:"+size+" ,price:"+price+" ,rating:"+rating+"}";
		
	}

}


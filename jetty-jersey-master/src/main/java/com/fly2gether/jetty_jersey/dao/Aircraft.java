package com.fly2gether.jetty_jersey.dao;


public class Aircraft {
	
	private String tailNumber;
	private String model;
	private String constructorCompany;
	private int numberOfSeats;
	
	/* CONSTRUCTORS */
	public Aircraft (){
        this.tailNumber = "";
        this.model = "";
        this.constructorCompany = "";
        this.numberOfSeats = 0;
    }
	public Aircraft (String model, String constructorCompany,int numberOfSeats){
        this.model = model;
        this.constructorCompany = constructorCompany;
        this.numberOfSeats = numberOfSeats;
    }	
	 /* GETTERS */
	String getTailNumber() {
		return this.tailNumber;
	}
	String getModel() {
		return this.model;
	}
	String getConstructorCompany() {
		return this.constructorCompany;
	}
	int getNumberOfSeats() {
		return this.numberOfSeats;
	}
	
	/* SETTERS */
	void setTailNumber(String tailNumber) {
		this.tailNumber=tailNumber;
	}
	void setModel(String model) {
		this.model=model;
	}
	void setConstructorCompany(String Company) {
		this.constructorCompany=Company;
	}
	void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats=numberOfSeats;
	}
	
}

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
	public String getTailNumber() {
		return this.tailNumber;
	}
	public String getModel() {
		return this.model;
	}
	public String getConstructorCompany() {
		return this.constructorCompany;
	}
	public int getNumberOfSeats() {
		return this.numberOfSeats;
	}
	
	/* SETTERS */
	public void setTailNumber(String tailNumber) {
		this.tailNumber=tailNumber;
	}
	public void setModel(String model) {
		this.model=model;
	}
	public void setConstructorCompany(String Company) {
		this.constructorCompany=Company;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats=numberOfSeats;
	}
	
}

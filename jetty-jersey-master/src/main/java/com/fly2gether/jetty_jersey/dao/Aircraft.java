package com.fly2gether.jetty_jersey.dao;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aircraft {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.NATIVE)
	private String tailNumber;
	private String model;
	private String constructorCompany;
	private int numberOfSeats;
	
	private static int nbAircraft=0;// permit to give an unique id
	
	/* CONSTRUCTORS */
	public Aircraft (){
        this.tailNumber = "";
        this.model = "";
        this.constructorCompany = "";
        this.numberOfSeats = 0;
        nbAircraft++;
       // id="AI"+nbAircraft;
        
    }
	public Aircraft (String model, String constructorCompany,int numberOfSeats){
        this.model = model;
        this.constructorCompany = constructorCompany;
        this.numberOfSeats = numberOfSeats;
        nbAircraft++;
        tailNumber="AI"+nbAircraft;
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

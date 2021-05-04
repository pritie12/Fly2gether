package com.fly2gether.jetty_jersey.dao;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aircraft {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	private Long aircraft_id;
	
	private Long tailNumber ;
	
	private String model;
	private String constructorCompany;
	private int numberOfSeats;
	
	
	/* CONSTRUCTORS */
	public Aircraft (){
        this.tailNumber = (long) 0;
        this.model = "";
        this.constructorCompany = "";
        this.numberOfSeats = 0;     
    }
	public Aircraft (String model, String constructorCompany,int numberOfSeats,Long tailNumber){
        this.model = model;
        this.constructorCompany = constructorCompany;
        this.numberOfSeats = numberOfSeats;
        this.tailNumber=tailNumber;
    }	
	 /* GETTERS */

	public Long getID() {
		return this.aircraft_id;
	}
	public Long getTailNumber() {
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
	public void setTailNumber(Long id) {
		this.tailNumber=id;
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
	/* DISPLAY */
	public void display() {
		System.out.println("Model: "+this.model+",Company: "+this.constructorCompany+", Seats: "+this.numberOfSeats+", TailNumber: "+this.tailNumber);
	}
	
}

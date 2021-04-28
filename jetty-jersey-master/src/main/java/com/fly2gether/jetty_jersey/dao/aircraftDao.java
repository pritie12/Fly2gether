package com.fly2gether.jetty_jersey.dao;

import java.util.List;

public interface aircraftDao {
	


	/* GET */
	public List<Aircraft> getFleet();
	public String getModel(int TailNumber);
	public String getCompany(int TailNumber);
	public int getNumberOfSeats(int TailNumber);
	public Aircraft getAircraft(int TailNumber);
	
	/* POST */
	public void setModel(int TailNumber,String Model);
	public void setCompany(int TailNumber, String Company);
	public void setNumberOfSeats(int TailNumber, int NumberOfSeats);

	
	/* PUT */
	public void addAircraft(Aircraft aircraft);
	
	/* DELETE */
	public void deleteAircraft(int TailNumber);
}

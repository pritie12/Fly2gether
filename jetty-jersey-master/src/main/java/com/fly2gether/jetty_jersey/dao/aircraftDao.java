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
	/* no post request here */
	
	/* PUT */
	public void addAircraft(Aircraft aircraft);
	
	/* DELETE */
	public void deleteAircraft(int TailNumber);
}

package com.fly2gether.jetty_jersey.dao;

import java.util.List;

public interface aircraftDao {
	


	/* GET */
	public List<Aircraft> getFleet();
	public String getModel(String TailNumber);
	public String getCompany(String TailNumber);
	public int getNumberOfSeats(String TailNumber);
	public Aircraft getAircraft(String TailNumber);
	
	/* POST */
	/* no post request here */
	
	/* PUT */
	public void addAircraft(Aircraft aircraft);
	
	/* DELETE */
	public void deleteAircraft(String TailNumber);
}

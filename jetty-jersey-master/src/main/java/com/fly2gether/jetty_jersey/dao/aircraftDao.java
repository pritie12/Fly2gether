package com.fly2gether.jetty_jersey.dao;



public interface aircraftDao {
	


	/* GET */
	public String getModel(String TailNumber);
	public String getCompany(String TailNumber);
	public int getNumberOfSeats(String TailNumber);
	
	/* POST */
	/* no post request here */
	
	/* PUT */
	void addAircraft(Aircraft aircraft);
	
	/* DELETE */
	/* no delete request here */
}

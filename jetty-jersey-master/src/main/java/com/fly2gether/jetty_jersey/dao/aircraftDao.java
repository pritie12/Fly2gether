package com.fly2gether.jetty_jersey.dao;

import java.util.List;

public interface aircraftDao {
	


	/* GET */
	public List<Aircraft> getFleet();
	public String getModel(Long TailNumber);
	public String getCompany(Long TailNumber);
	public int getNumberOfSeats(Long TailNumber);
	public Aircraft getAircraft(Long TailNumber);
	
	/* POST */
	public void setModel(Long TailNumber,String Model);
	public void setCompany(Long TailNumber, String Company);
	public void setNumberOfSeats(Long TailNumber, int NumberOfSeats);

	
	/* PUT */
	public void addAircraft(Aircraft aircraft);
	
	/* DELETE */
	public void deleteAircraft(Long TailNumber);
}

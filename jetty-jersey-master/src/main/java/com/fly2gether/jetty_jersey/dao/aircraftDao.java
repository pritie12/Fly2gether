package com.fly2gether.jetty_jersey.dao;

import java.util.List;

public interface aircraftDao {
	


	/* GET */
	public List<Aircraft> getFleet();
	public String getModel(Long id);
	public String getCompany(Long id);
	public int getNumberOfSeats(Long id);
	public Aircraft getAircraft(Long id);
	public long getAircraftId(Long tailNum);
	
	/* POST */
	public void setModel(Long TailNumber,String Model);
	public void setCompany(Long TailNumber, String Company);
	public void setNumberOfSeats(Long TailNumber, int NumberOfSeats);

	
	/* PUT */
	public void addAircraft(Aircraft aircraft);
	
	/* DELETE */
	public void deleteAircraft(Long TailNumber);
}

package com.example.jetty_jersey.dao;
import java.util.List;



public interface aircraftDao {
	
	List<Aircraft> getAircrafts();

	
	public String getTailNumber(Aircraft aircraft);
	public String getModel(Aircraft aircraft);
	public int getFlyingHours(Aircraft aircraft);
	public String getCompany(Aircraft aircraft);
	public int getNumberOfSeats(Aircraft aircraft);
	
	void addAircraft(Aircraft aircraft);
	void removeAircraft(Aircraft aircraft);
}

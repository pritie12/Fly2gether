package com.example.jetty_jersey.dao;
import java.util.Date;
import java.util.List;

public interface flightDao {
	
	/* GET */
	String getId();
	Pilot getPilot(String id);	
	Aircraft getAircraft(String id);
	int getPrice(String id);
	List<Passenger> getPassengers(String id);
	int getAvailableSeats(String id);	
	String getAppointmentDescription(String id);	
	Date getdepartureDateTime(String id);
	String getdepartureAirport(String id);	
	Date getarrivalDateTime(String id);
	String getarrivalAirport(String id);
	
	//filter the flights by price
	List<Flight> getFlights(int minPrice,int maxPrice);
	//one way trip
	List<Flight> getFlights(Date DepartureTime, String DepartureAirport);	
	//round-trip
	List<Flight> getFlights(Date DepartureTime, String DepartureAirport,Date ArrivalTime, String ArrivalAirport);	
	//display flights that still have the number of seats desired 
	List<Flight> getFlights(int availableSeats);
	
	
	/* ADD */
	void addFlight();
	public void addPassenger(String passenger_id, String flight_id);
	
	
	/* DELETE */
	void deleteFlight(String id);
	void removePassenger(String passenger_id);
	
}

package com.fly2gether.jetty_jersey.dao;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface flightDao {
	
	/* GET */

	public Pilot getPilot(String id);	
	public Aircraft getAircraft(String id);
	public int getPrice(String id);
	public List<String> getPassengers(String id);
	public int getAvailableSeats(String id);	
	public String getAppointmentDescription(String id);	
	public Date getdepartureDate(String id);
	public LocalDateTime getdepartureTime(String id);
	public String getdepartureAirport(String id);	
	public Date getarrivalDate(String id);
	public LocalDateTime getarrivalTime(String id);
	public String getarrivalAirport(String id);
	public Duration getFlightDuration(String id);
	
	//filter the flights by price
	public List<Flight> getFlights(int minPrice,int maxPrice);
	//one way trip
	public List<Flight> getFlights(Date DepartureTime, String DepartureAirport);	
	//round-trip
	public List<Flight> getFlights(Date DepartureTime, String DepartureAirport,Date ArrivalTime, String ArrivalAirport);	
	//display flights that still have the number of seats desired 
	public List<Flight> getFlights(int availableSeats);
	
	
	/* PUT */
	public void addFlight(Flight flight);
	public void addPassenger(String passenger_id, String flight_id);
	
	
	/* DELETE */
	public void deleteFlight(String id);
	public void removePassenger(String passenger_id,String flight_id);
	
}

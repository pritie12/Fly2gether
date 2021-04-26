package com.fly2gether.jetty_jersey.dao;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface flightDao {
	
	/* GET */

	public Pilot getPilot(int id);	
	public Aircraft getAircraft(int id);
	public int getPrice(int id);
	public List<Integer> getPassengers(int id);
	public int getAvailableSeats(int id);	
	public String getAppointmentDescription(int id);	
	public Date getdepartureDate(int id);
	public LocalDateTime getdepartureTime(int id);
	public String getdepartureAirport(int id);	
	public Date getarrivalDate(int id);
	public LocalDateTime getarrivalTime(int id);
	public String getarrivalAirport(int id);
	public Duration getFlightDuration(int id);
	public List<Flight> getFlights();
	
	//filter the flights by price
	public List<Flight> getFlights(int minPrice,int maxPrice);
	//one way trip
	public List<Flight> getFlights(Date DepartureTime, String DepartureAirport);		
	//display flights that still have the number of seats desired 
	public List<Flight> getFlights(int availableSeats);
	
	
	/* PUT */
	public void addFlight(Flight flight);
	public void addPassenger(int passenger_id, int flight_id);
	
	
	/* DELETE */
	public void deleteFlight(int id);
	public void removePassenger(int passenger_id,int flight_id);
	
}

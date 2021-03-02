package com.example.jetty_jersey.dao;
import java.util.Date;
import java.util.List;

public interface flightDao {
	List<Flight> getFlights();
	
	public Pilote getPilot(Flight flight);	
	public Aircraft getAircraft(Flight flight);
	public double getPrice(Flight flight);
	public List<Passenger> getPassengers(Flight flight);
	public int getAvailableSeats(Flight flight);
	
	public String getId(Flight flight);
	
	String getAppointmentDescription(Flight flight);
	
	Date getdepartureDateTime(Flight flight);
	String getdepartureAirport(Flight flight);
	
	Date getarrivalDateTime(Flight flight);
	String getarrivalAirport(Flight flight);// Location 
	
	//filter the flights by price
	List<Flight> getFlights(int minPrice,int maxPrice);
	//one way trip
	List<Flight> getFlights(Date DepartureTime, String DepartureAirport);	
	//round-trip
	List<Flight> getFlights(Date DepartureTime, String DepartureAirport,Date ArrivalTime, String ArrivalAirport);
	
	//display flights that still have the number of seats desired 
	List<Flight> getFlights(int availableSeats);
	
	void addFlight(	Flight flight);
	void deleteFlight(	Flight flight);
	
}

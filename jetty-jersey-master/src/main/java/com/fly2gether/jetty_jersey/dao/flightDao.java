package com.fly2gether.jetty_jersey.dao;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface flightDao {
	
	/* GET */

	public Long getPilot(Long id);	
	public Long getAircraft(Long id);
	public int getPrice(Long id);
	public List<Long> getPassengersList(Long id);
	public int getAvailableSeats(Long id);	
	public String getAppointmentDescription(Long id);	
	public Date getdepartureDate(Long id);
	public LocalDateTime getdepartureTime(Long id);
	public String getdepartureAirport(Long id);	
	public Date getarrivalDate(Long id);
	public LocalDateTime getarrivalTime(Long id);
	public String getarrivalAirport(Long id);
	public Duration getFlightDuration(Long id);
	public List<Flight> getFlights();
	public Flight getFlight(Long id);
	
	//filter the flights 
	public List<Reservation> getReservationsForFlight(long flight_id);
	public List<Flight> getFlights(int minPrice,int maxPrice);
	public List<Flight> getFlights(String DepartureMin,String DepartureMax, String DepartureAirport);	
	public List<Flight> getFlights(int Seats);	
	public List<Flight> SearchFlight(int seats,int maxprice,int minprice,String DepartureMin,String DepartureMax, String DepartureAirport);
	
	/* POST */
	public void setPilot(Long id,Long Pilot);	
	public void setAircraft(Long id,Long Aircraft);
	public void setPrice(Long id,int Price);
	public void setPassengers(Long id,List<Long> Passengers);
	public void setAvailableSeats(Long id, int AvailableSeats);	
	public void setAppointmentDescription(Long id,String AppointmentDescription);	
	public void setdepartureDate(Long id,Date DepartureDate);	
	public void setarrivalDate(Long id,Date ArrivalDate);
	public void setFlightDuration(Long id,Duration FlightDuration);
	public void modifyFlight(Long id, String DepartureTime,String DepartureAirport, String ArrivalTime,String ArrivalAirport);
	
	/* PUT */
	public void addFlight(Flight flight);
	public void addPassenger(Long passenger_id, Long flight_id);
	
	
	/* DELETE */
	public void deleteFlight(Long id);
	public void removePassenger(Long passenger_id,Long flight_id);
	
}

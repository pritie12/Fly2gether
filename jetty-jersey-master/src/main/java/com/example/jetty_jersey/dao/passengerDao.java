package com.example.jetty_jersey.dao;
import java.util.Date;
import java.util.List;

public interface passengerDao {
	
	List<Passenger> getPassengers();
	
	public String getPassengerId(Passenger passenger);
	public String getname(Passenger passenger);
	public String getsurname(Passenger passenger);
	public Date getdateOfBirth(Passenger passenger);
	public String getemail(Passenger passenger);
	public String getphoneNumber(Passenger passenger);
	public List<Reservation> getpassengerBookingList(Passenger passenger);
	
	//get the list of passengers of a certain date and a certain airport
	List<Passenger> getPassengers(Date Time, String Airport);
	
	public void addPassenger(Passenger passenger, Flight flight);
	void deletePassenger(Passenger passenger,Flight flight);
}

package com.example.jetty_jersey.dao;
import java.util.List;

public interface reservationDao {
	List<Reservation> getReservations();
	
	//get all the reservations of a certain passenger
	List<Reservation> getReservations(Passenger passenger);

}

package com.fly2gether.jetty_jersey.dao;
import java.util.List;

public interface reservationDao {

	/* GET */
	Passenger getbookingUser(String resa_id);
	int getdesiredSeats(String resa_id);
	Flight getFlight(String resa_id);
	//get all the reservations of a certain passenger
	List<Reservation> getReservations(String passenger_id);
	
	
	
	/* POST */
	void changeNumberOfSeats(int seats);
	
	/* PUT */
	
	/* DELETE */

}

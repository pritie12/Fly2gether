package com.fly2gether.jetty_jersey.dao;
import java.util.List;

public interface reservationDao {

	/* GET */
	public List<Reservation> getReservations();
	public Reservation getReservation(String reservation_id);
	public Passenger getbookingUser(String reservation_id);
	public int getdesiredSeats(String reservation_id);
	public Flight getFlight(String reservation_id);
	//get all the reservations of a certain passenger
	public List<String> getReservations(String passenger_id); // ID of reservations
	
	
	
	/* POST */
	public void changeNumberOfSeats(int seats,String reservation_id);
	
	/* PUT */
	public void addReservation(Reservation reservation);
	
	/* DELETE */
	public void deleteReservation(String id);

}

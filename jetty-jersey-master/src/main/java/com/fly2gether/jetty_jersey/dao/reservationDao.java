package com.fly2gether.jetty_jersey.dao;
import java.util.List;

public interface reservationDao {

	/* GET */
	public List<Reservation> getReservations();
	public Reservation getReservation(int reservation_id);
	public Passenger getbookingUser(int reservation_id);
	public int getdesiredSeats(int reservation_id);
	public Flight getFlight(int reservation_id);
	public boolean getStatus(int reservation_id);
	//get all the reservations of a certain passenger
	public List<Integer> getReservations(int passenger_id); // ID of reservations
	
	
	
	/* POST */
	public void changeNumberOfSeats(int seats,int reservation_id);
	public void denyReservation(int reservation_id);
	
	/* PUT */
	public void addReservation(Reservation reservation);
	
	/* DELETE */
	public void deleteReservation(int id);

}

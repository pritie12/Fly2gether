package com.fly2gether.jetty_jersey.dao;
import java.util.List;

public interface reservationDao {

	/* GET */
	public List<Reservation> getReservations();
	public Reservation getReservation(Long reservation_id);
	public Long getbookingUser(Long reservation_id);
	public int getdesiredSeats(Long reservation_id);
	public Long getFlight(Long reservation_id);
	public boolean getStatus(Long reservation_id);
	//get all the reservations of a certain passenger
	public List<Long> getReservations(Long passenger_id); // ID of reservations
	
	
	
	/* POST */
	public void changeNumberOfSeats(int seats,Long reservation_id);
	
	/* PUT */
	public void addReservation(Reservation reservation);
	
	/* DELETE */
	public void denyReservation(Long id);

}

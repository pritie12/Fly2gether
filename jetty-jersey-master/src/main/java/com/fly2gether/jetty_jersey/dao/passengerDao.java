package com.fly2gether.jetty_jersey.dao;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface passengerDao {
	

	/* GET */
	Map<String,String> getLoginInfo(String Id);
	String getname(String id);
	String getsurname(String id);
	Date getdateOfBirth(String id);
	String getemail(String id);
	String getphoneNumber(String id);
	List<Reservation> getpassengerBookingList(String id);
	
	/* POST */
	/* no post requests here */
	
	/* PUT */
	void addPassenger(Passenger passenger);
	void addReservation(String passenger_id,String resa_id);
	
	/* DELETE*/ 
	void removeReservation(String passenger_id,String resa_id);
}

package com.fly2gether.jetty_jersey.dao;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface passengerDao {
	

	/* GET */
	Map<String,String> getLoginInfo(String Id);
	String getname(String passenger_id);
	String getsurname(String passenger_id);
	Date getdateOfBirth(String passenger_id);
	String getemail(String passenger_id);
	String getphoneNumber(String passenger_id);
	List<String> getpassengerBookingList(String passenger_id);
	
	/* POST */
	/* no post requests here */
	
	/* PUT */
	void addPassenger(Passenger passenger);
	void addReservation(String passenger_id,String resa_id);
	
	/* DELETE*/ 
	void removeReservation(String passenger_id,String resa_id);
}

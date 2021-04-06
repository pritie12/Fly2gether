package com.fly2gether.jetty_jersey.dao;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface passengerDao {
	

	/* GET */
	public List<Passenger> getPassengers();
	public Passenger getPassenger(String id);
	public Map<String,String> getLoginInfo(String Id);
	public String getname(String passenger_id);
	public String getsurname(String passenger_id);
	public Date getdateOfBirth(String passenger_id);
	public String getemail(String passenger_id);
	public String getphoneNumber(String passenger_id);
	public List<String> getpassengerBookingList(String passenger_id);
	
	/* POST */
	/* no post requests here */
	
	/* PUT */
	public void addPassenger(Passenger passenger);
	public void addReservation(String passenger_id,String resa_id);
	
	/* DELETE*/ 
	public void removeReservation(String passenger_id,String resa_id);
	public void deletePassenger(String id);

}

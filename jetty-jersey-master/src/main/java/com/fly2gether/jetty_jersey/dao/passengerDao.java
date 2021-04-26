package com.fly2gether.jetty_jersey.dao;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface passengerDao {
	

	/* GET */
	public List<Passenger> getPassengers();
	public Passenger getPassenger(int id);
	public Map<String,String> getLoginInfo(int Id);
	public String getname(int passenger_id);
	public String getsurname(int passenger_id);
	public Date getdateOfBirth(int passenger_id);
	public String getemail(int passenger_id);
	public String getphoneNumber(int passenger_id);
	public List<Integer> getpassengerBookingList(int passenger_id);
	
	/* POST */
	/* no post requests here */
	
	/* PUT */
	public void addPassenger(Passenger passenger);
	public void addReservation(int passenger_id,int resa_id);
	
	/* DELETE*/ 
	public void removeReservation(int passenger_id,int resa_id);
	public void deletePassenger(int id);

}

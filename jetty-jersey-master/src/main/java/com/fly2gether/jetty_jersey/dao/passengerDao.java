package com.fly2gether.jetty_jersey.dao;
import java.util.Date;
import java.util.List;

public interface passengerDao {
	

	/* GET */
	public List<Passenger> getPassengers();
	public Passenger Login(String username, String password);
	public Passenger getPassenger(String Username);
	public String getUsername(Long id);
	public String getPwd(Long id);
	public Passenger getPassenger(Long id);
	public String getname(Long passenger_id);
	public String getsurname(Long passenger_id);
	public Date getdateOfBirth(Long passenger_id);
	public String getemail(Long passenger_id);
	public String getphoneNumber(Long passenger_id);
	public List<Long> getpassengerBookingList(Long passenger_id);
	
	/* POST */
	public void modifyUsername(Long id,String Username);
	public void modifyPwd(Long id,String Pwd);
	
	/* PUT */
	public void addPassenger(Passenger passenger);
	public void addReservation(Long passenger_id,Long resa_id);
	
	/* DELETE*/ 
	public void cancelReservation(Long passenger_id,Long resa_id);
	public void deletePassenger(Long id);

}

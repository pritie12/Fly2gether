package com.fly2gether.jetty_jersey.dao;
import java.util.Date;
import java.util.List;

public interface passengerDao {
	

	/* GET */
	public List<Passenger> getPassengers();
	public Passenger Login(String username, String password);
	public Passenger getPassenger(String Username);
	public String getUsername(int id);
	public String getPwd(int id);
	public Passenger getPassenger(int id);
	public String getname(int passenger_id);
	public String getsurname(int passenger_id);
	public Date getdateOfBirth(int passenger_id);
	public String getemail(int passenger_id);
	public String getphoneNumber(int passenger_id);
	public List<Integer> getpassengerBookingList(int passenger_id);
	
	/* POST */
	public void modifyUsername(int id,String Username);
	public void modifyPwd(int id,String Pwd);
	
	/* PUT */
	public void addPassenger(Passenger passenger);
	public void addReservation(int passenger_id,int resa_id);
	
	/* DELETE*/ 
	public void cancelReservation(int passenger_id,int resa_id);
	public void deletePassenger(int id);

}

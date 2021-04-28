package com.fly2gether.jetty_jersey.dao;
import java.util.Date;
import java.util.List;


public interface pilotDao {
	
	/* GET */
	public List<Pilot> getPilots();
	public Pilot Login(String username, String password);
	public Pilot getPilot(String Username);
	public Pilot getPilot(int id);	
	public String getname(int id);
	public String getsurname(int id);
	public Date getdateOfBirth(int id);
	public String getemail(int id);
	public String getphoneNumber(int id);
	public int getFlyingHours(int id);
	
	/* POST */
	public void modifyUsername(int id,String Username);
	public void modifyPwd(int id,String Pwd);
	
	/* PUT */
	public void addPilot(Pilot pilot);
	
	/* DELETE */
	public void deletePilot(int id);


}

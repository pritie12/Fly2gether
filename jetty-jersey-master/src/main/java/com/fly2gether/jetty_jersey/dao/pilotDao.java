package com.fly2gether.jetty_jersey.dao;
import java.util.Date;
import java.util.List;
import java.util.Map;


public interface pilotDao {
	
	/* GET */
	public List<Pilot> getPilots();
	public Pilot getPilot(int id);	
	public Map<String,String> getLoginInfo(int Id);
	public String getname(int id);
	public String getsurname(int id);
	public Date getdateOfBirth(int id);
	public String getemail(int id);
	public String getphoneNumber(int id);
	public int getFlyingHours(int id);
	
	/* POST */
	/* no post requests here */
	
	/* PUT */
	public void addPilot(Pilot pilot);
	
	/* DELETE */
	public void deletePilot(int id);


}

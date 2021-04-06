package com.fly2gether.jetty_jersey.dao;
import java.util.Date;
import java.util.List;
import java.util.Map;


public interface pilotDao {
	
	/* GET */
	public List<Pilot> getPilots();
	public Pilot getPilot(String id);	
	public Map<String,String> getLoginInfo(String Id);
	public String getname(String id);
	public String getsurname(String id);
	public Date getdateOfBirth(String id);
	public String getemail(String id);
	public String getphoneNumber(String id);
	public int getFlyingHours(String id);
	
	/* POST */
	/* no post requests here */
	
	/* PUT */
	public void addPilot(Pilot pilot);
	
	/* DELETE */
	public void deletePilot(String id);


}

package com.fly2gether.jetty_jersey.dao;
import java.util.Date;
import java.util.List;


public interface pilotDao {
	
	/* GET */
	public List<Pilot> getPilots();
	public long Login(String username, String password);
	public Pilot getPilot(String Username);
	public Pilot getPilot(Long id);	
	public String getname(Long id);
	public String getsurname(Long id);
	public Date getdateOfBirth(Long id);
	public String getemail(Long id);
	public String getphoneNumber(Long id);
	public int getFlyingHours(Long id);
	
	/* POST */
	public void modifyUsername(Long id,String Username);
	public void modifyPwd(Long id,String Pwd);
	
	/* PUT */
	public void addPilot(Pilot pilot);
	
	/* DELETE */
	public void deletePilot(Long id);


}

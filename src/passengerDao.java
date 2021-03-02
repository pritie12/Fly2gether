import java.util.Date;
import java.util.List;

public interface passengerDao {
	
	List<Passenger> getPassengers();
	
	
	//get the list of passengers of a certain date and a certain airport
	List<Passenger> getPassengers(Date Time, String Airport);
	
	public void addPassenger(Passenger passenger, Flight flight);
	void deletePassenger(Passenger passenger,Flight flight);
}

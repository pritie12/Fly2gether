import java.util.Date;
import java.util.List;

public interface passengerDao {
	
	List<Passenger> getPassengers();
	
	//get the list of passengers of a certain flight
	List<Passenger> getPassengers(Flight flight);
	
	//get the list of passengers of a certain date and a certain airport
	List<Passenger> getPassengers(Date Time, String Airport);	
}

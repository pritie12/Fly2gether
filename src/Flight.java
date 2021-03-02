import java.util.Date;
import java.util.List;



public class Flight {
	int id;
	
	Date appointmentDateTime;
	String appointmentAirport;
	
	Date departureDateTime;
	String departureAirport;
	
	Date arrivalDateTime;
	String arrivalAirport;// Location 
	
	int availablesSeats;
	double price; // by seats
	List<Passenger> passengers;
	Pilote pilot;
	Aircraft aircraft;
		
	
}

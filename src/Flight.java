import java.util.Date;
import java.util.List;

public class Flight {
	int id;
	
	Date appointementDateTime;
	String appointementAirport;
	
	Date departureDateTime;
	String departureAirport;
	
	Date arrivalDateTime;
	String arrivalAirport;// Location 
	
	int availablesSeats;
	double price; // by seats
	List<Reservation> bookingList;
	Pilote pilot;
	Aircraft aircraf;
	
	
	
}

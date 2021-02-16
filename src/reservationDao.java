import java.util.List;

public interface reservationDao {
	List<Reservation> getReservations();
	
	//get all the reservations of a certain passenger
	List<Reservation> getReservations(Passenger passenger);

	//get all the reservations of passengers using a certain payment Method
	List<Reservation> getReservations(String paymentMethod);
}

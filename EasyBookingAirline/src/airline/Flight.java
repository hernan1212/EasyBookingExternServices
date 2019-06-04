package airline;

import java.util.List;


public class Flight {
	
    int flight_number;
	String departure_date;
	String arrival_date;
	int total_seats;
	boolean aero;
	int precio;

    List<Reservation> bookings;
    Airport Departure;
    Airport Arrival;

	public Flight(int flight_number, String departure_date, String arrival_date, int total_seats, int precio,
			List<Reservation> bookings, Airport departure, Airport arrival) {
		super();
		this.flight_number = flight_number;
		this.departure_date = departure_date;
		this.arrival_date = arrival_date;
		this.total_seats = total_seats;
		this.precio = precio;
		this.bookings = bookings;
		Departure = departure;
		Arrival = arrival;
	}
	public Flight() {
	}




	public int getPrecio() {
		return precio;
	}



	public void setPrecio(int precio) {
		this.precio = precio;
	}



	public int getFlight_number() {
		return flight_number;
	}



	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}



	public String getDeparture_date() {
		return departure_date;
	}



	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}



	public String getArrival_date() {
		return arrival_date;
	}



	public void setArrival_date(String arrival_date) {
		this.arrival_date = arrival_date;
	}



	public int getTotal_seats() {
		return total_seats;
	}



	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
	}



	public List<Reservation> getBookings() {
		return bookings;
	}



	public void setBookings(List<Reservation> bookings) {
		this.bookings = bookings;
	}



	public Airport getDeparture() {
		return Departure;
	}



	public void setDeparture(Airport departure) {
		Departure = departure;
	}



	public Airport getArrival() {
		return Arrival;
	}
	public void setArrival(Airport arrival) {
		Arrival = arrival;
	}



	public boolean isAero() {
		return aero;
	}



	public void setAero(boolean aero) {
		this.aero = aero;
	}
	
    
}

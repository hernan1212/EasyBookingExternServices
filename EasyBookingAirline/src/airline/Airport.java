package airline;

import java.util.ArrayList;
import java.util.List;



public class Airport {


    int code = 0;
	String place;
	

	List<Flight> departure_flights = new ArrayList<>();
	

	List<Flight> arrival_flights = new ArrayList<>();
	

	List<User> usuarios = new ArrayList<>();

	
	public Airport(int code, String place) {
		this.code = code;
		this.place = place;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
}

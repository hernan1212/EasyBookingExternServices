package airline;



import java.util.ArrayList;
import java.util.List;


public class User {


    String email;
	String password;
	String payment_name;
	String aut_sys_name;
	
	List<Reservation> bookings = new ArrayList<Reservation>();
	
	

	public User(String email, String password, String payment_name, String aut_sys_name) {
		super();
		this.email = email;
		this.password = password;
		this.payment_name = payment_name;
		this.aut_sys_name = aut_sys_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPayment_name() {
		return payment_name;
	}

	public void setPayment_name(String payment_name) {
		this.payment_name = payment_name;
	}

	public String getAut_sys_name() {
		return aut_sys_name;
	}

	public void setAut_sys_name(String aut_sys_name) {
		this.aut_sys_name = aut_sys_name;
	}

	public List<Reservation> getBookings() {
		return bookings;
	}

	public void setBookings(List<Reservation> bookings) {
		this.bookings = bookings;
	}
	
	
}

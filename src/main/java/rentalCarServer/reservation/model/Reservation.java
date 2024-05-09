package rentalCarServer.reservation.model;

import java.sql.Timestamp;

public class Reservation {
	private String userId;
	private String carNumber;
	private int resevNumber;
	private Timestamp resevDate;
	private Timestamp returnDate;
	private Timestamp resevAddDate;
	private Timestamp resevModDate;
	
	public Reservation(String userId, String carNumber, int resevNumber, Timestamp resevDate, Timestamp returnDate, Timestamp resevAddDate, Timestamp resevModDate) {
		super();
		this.userId = userId;
		this.carNumber = carNumber;
		this.resevNumber = resevNumber;
		this.resevDate = resevDate;
		this.returnDate = returnDate;
		this.resevAddDate = resevAddDate;
		this.resevModDate = resevModDate;
	}
	
	public Reservation() {
		
	}

	public String getUserId() {
		return userId;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public int getResevNumber() {
		return resevNumber;
	}

	public Timestamp getResevDate() {
		return resevDate;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public Timestamp getResevAddDate() {
		return resevAddDate;
	}

	public Timestamp getResevModDate() {
		return resevModDate;
	}
	
	
}

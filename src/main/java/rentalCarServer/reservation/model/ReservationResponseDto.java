package rentalCarServer.reservation.model;

import java.sql.Timestamp;

public class ReservationResponseDto {
	private String userId;
	private String carNumber;
	private int resevNumber;
	private Timestamp resevDate;
	private Timestamp returnDate;
	private Timestamp resevAddDate;
	private Timestamp resevModDate;
	
	public ReservationResponseDto(String userId, String carNumber, int resevNumber, Timestamp resevDate, Timestamp returnDate, Timestamp resevAddDate, Timestamp resevModDate) {
		super();
		this.userId = userId;
		this.carNumber = carNumber;
		this.resevNumber = resevNumber;
		this.resevDate = resevDate;
		this.returnDate = returnDate;
		this.resevAddDate = resevAddDate;
		this.resevModDate = resevModDate;
	}
	
	public ReservationResponseDto() {
		
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

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public void setResevNumber(int resevNumber) {
		this.resevNumber = resevNumber;
	}

	public void setResevDate(Timestamp resevDate) {
		this.resevDate = resevDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	public void setResevAddDate(Timestamp resevAddDate) {
		this.resevAddDate = resevAddDate;
	}

	public void setResevModDate(Timestamp resevModDate) {
		this.resevModDate = resevModDate;
	}
	
	
}

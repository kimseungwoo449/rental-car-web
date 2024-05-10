package rentalCarServer.reservation.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ReservationDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static ReservationDao instance = new ReservationDao();

	private ReservationDao() {

	}

	public static ReservationDao getInstance() {
		return instance;
	}
}

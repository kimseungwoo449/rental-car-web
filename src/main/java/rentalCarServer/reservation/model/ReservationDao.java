package rentalCarServer.reservation.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import rentalCarServer.util.DBManager;

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


	public List<ReservationResponseDto> createReservationList(ReservationRequestDto resevDto) {
		List<ReservationResponseDto> list = new ArrayList<ReservationResponseDto>();

		try {
			conn = DBManager.getConnection();

			Timestamp startDate = resevDto.getResevDate();
			Timestamp endDate = resevDto.getReturnDate();
			
			// 예약 불가 차량
			String sql = "SELECT * FROM reservation " + "WHERE (resev_date<=? AND return_date>=?) " + "OR (resev_date BETWEEN ? AND ?) " + "OR (return_date BETWEEN ? AND ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, startDate);
			pstmt.setTimestamp(2, endDate);
			pstmt.setTimestamp(3, startDate);
			pstmt.setTimestamp(4, endDate);
			pstmt.setTimestamp(5, startDate);
			pstmt.setTimestamp(6, endDate);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String userId = rs.getString(1);
				String carNumber = rs.getString(2);
				int resevNumber = rs.getInt(3);
				Timestamp resevDate = rs.getTimestamp(4);
				Timestamp returnDate = rs.getTimestamp(5);
				Timestamp resevAddDate = rs.getTimestamp(6);
				Timestamp resevModDate = rs.getTimestamp(7);
				ReservationResponseDto reservation = new ReservationResponseDto(userId, carNumber, resevNumber, resevDate, returnDate, resevAddDate, resevModDate);
				list.add(reservation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}

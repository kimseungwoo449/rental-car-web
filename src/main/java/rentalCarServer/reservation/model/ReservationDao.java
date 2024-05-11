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
	
	public ReservationResponseDto createReservation(ReservationRequestDto reservationDto) {
		ReservationResponseDto response = null;
		
		try {
			conn = DBManager.getConnection();

			String sql = "INSERT INTO reservation (`user_id`, `car_no`, `resev_date`, `return_date`) "
					+"VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			// sql 구문에 맵핑할 값 설정 <- column Index는 1부터! <- ?에 맵핑할것
			pstmt.setString(1, reservationDto.getUserId());
			pstmt.setString(2, reservationDto.getCarNumber());
			pstmt.setTimestamp(3, reservationDto.getResevDate());
			pstmt.setTimestamp(4, reservationDto.getReturnDate());

			pstmt.execute();
			
			response = findReservationByReservationNumber(lastInsertReservationNumber());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return response;
	}
	
	public ReservationResponseDto findReservationByReservationNumber(int reservationNumber) {
		ReservationResponseDto reservation = null;
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM reservation WHERE `resev_no` =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reservationNumber);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String userId = rs.getString(1);
				String carNumber = rs.getString(2);
				Timestamp resevDate = rs.getTimestamp(4);
				Timestamp returnDate = rs.getTimestamp(5);
				Timestamp resevAddDate = rs.getTimestamp(6);
				Timestamp resevModDate = rs.getTimestamp(7);

				reservation = new ReservationResponseDto(userId, carNumber, reservationNumber, resevDate, returnDate, resevAddDate, resevModDate);
			}
			return reservation;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return reservation;
	}
	
	private int lastInsertReservationNumber() {
		int lastReservationNumber = -1;
		try {
			String sql = "SELECT MAX(resev_no) FROM reservation";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				lastReservationNumber = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastReservationNumber;
	}
}

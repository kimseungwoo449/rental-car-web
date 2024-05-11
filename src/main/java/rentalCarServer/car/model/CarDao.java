package rentalCarServer.car.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import rentalCarServer.user.model.User;
import rentalCarServer.user.model.UserDao;
import rentalCarServer.util.DBManager;

public class CarDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static CarDao instance = new CarDao();

	private CarDao() {

	}

	public static CarDao getInstance() {
		return instance;
	}
	
	public List<CarResponseDto> createAllCarList(){
		List<CarResponseDto> list = new ArrayList<CarResponseDto>();
		
		try {
			conn = DBManager.getConnection();
			// 쿼리할 준비
			String sql = "SELECT * FROM cars";
			pstmt = conn.prepareStatement(sql);

			// 쿼리 실행
			rs = pstmt.executeQuery();

			// 튜플 읽기
			while (rs.next()) {
				// database의 column index는 1부터 시작함
				String carNumber = rs.getString(1);
				int categoryNumber = rs.getInt(2);
				String carName = rs.getString(3);
				int carAge = rs.getInt(4);
				int passengersNumber = rs.getInt(5);
				String fuelType = rs.getString(6);
				int hourlyRentalPrice = rs.getInt(7);
				
				CarResponseDto temp = new CarResponseDto(carNumber, categoryNumber, carName, carAge, passengersNumber, fuelType, hourlyRentalPrice);	
				list.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return list;
	}
	
	public List<CarResponseDto> findCarsByCategory(int searchValue){
		List<CarResponseDto> list = new ArrayList<CarResponseDto>();
		
		try {
			conn = DBManager.getConnection();
			// 쿼리할 준비
			String sql = "SELECT * FROM cars WHERE cate_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, searchValue);
			// 쿼리 실행
			rs = pstmt.executeQuery();

			// 튜플 읽기
			while (rs.next()) {
				// database의 column index는 1부터 시작함
				String carNumber = rs.getString(1);
				int categoryNumber = rs.getInt(2);
				String carName = rs.getString(3);
				int carAge = rs.getInt(4);
				int passengersNumber = rs.getInt(5);
				String fuelType = rs.getString(6);
				int hourlyRentalPrice = rs.getInt(7);
				
				CarResponseDto temp = new CarResponseDto(carNumber, categoryNumber, carName, carAge, passengersNumber, fuelType, hourlyRentalPrice);	
				list.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return list;
	}
	
	public List<CarResponseDto> findCarsByCarName(String searchValue){
		List<CarResponseDto> list = new ArrayList<CarResponseDto>();
		
		try {
			conn = DBManager.getConnection();
			// 쿼리할 준비
			String sql = "SELECT * FROM cars WHERE car_name LIKE CONCAT('%',?,'%')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchValue);
			// 쿼리 실행
			rs = pstmt.executeQuery();

			// 튜플 읽기
			while (rs.next()) {
				// database의 column index는 1부터 시작함
				String carNumber = rs.getString(1);
				int categoryNumber = rs.getInt(2);
				String carName = rs.getString(3);
				int carAge = rs.getInt(4);
				int passengersNumber = rs.getInt(5);
				String fuelType = rs.getString(6);
				int hourlyRentalPrice = rs.getInt(7);
				
				CarResponseDto temp = new CarResponseDto(carNumber, categoryNumber, carName, carAge, passengersNumber, fuelType, hourlyRentalPrice);	
				list.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return list;
	}
	
	public List<CarResponseDto> findCarsByMinimumPassengers(int searchValue){
		List<CarResponseDto> list = new ArrayList<CarResponseDto>();
		
		try {
			conn = DBManager.getConnection();
			// 쿼리할 준비
			String sql = "SELECT * FROM cars WHERE passengers_no >= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, searchValue);
			// 쿼리 실행
			rs = pstmt.executeQuery();

			// 튜플 읽기
			while (rs.next()) {
				// database의 column index는 1부터 시작함
				String carNumber = rs.getString(1);
				int categoryNumber = rs.getInt(2);
				String carName = rs.getString(3);
				int carAge = rs.getInt(4);
				int passengersNumber = rs.getInt(5);
				String fuelType = rs.getString(6);
				int hourlyRentalPrice = rs.getInt(7);
				
				CarResponseDto temp = new CarResponseDto(carNumber, categoryNumber, carName, carAge, passengersNumber, fuelType, hourlyRentalPrice);	
				list.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return list;
	}
	
	public CarResponseDto findCarsByCarNumber(String value){
		CarResponseDto response = null;
		try {
			conn = DBManager.getConnection();
			// 쿼리할 준비
			String sql = "SELECT * FROM cars WHERE car_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			// 쿼리 실행
			rs = pstmt.executeQuery();

			// 튜플 읽기
			while (rs.next()) {
				// database의 column index는 1부터 시작함
				String carNumber = rs.getString(1);
				int categoryNumber = rs.getInt(2);
				String carName = rs.getString(3);
				int carAge = rs.getInt(4);
				int passengersNumber = rs.getInt(5);
				String fuelType = rs.getString(6);
				int hourlyRentalPrice = rs.getInt(7);
				
				response = new CarResponseDto(carNumber, categoryNumber, carName, carAge, passengersNumber, fuelType, hourlyRentalPrice);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return response;
	}
}

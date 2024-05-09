package rentalCarServer.car.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import rentalCarServer.user.model.UserDao;

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
}

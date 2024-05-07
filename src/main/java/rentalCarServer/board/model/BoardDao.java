package rentalCarServer.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class BoardDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static BoardDao instance = new BoardDao();

	private BoardDao() {

	}

	public static BoardDao getInstance() {
		return instance;
	}
}
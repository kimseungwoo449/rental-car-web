package rentalCarServer.board.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import rentalCarServer.util.DBManager;


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
	
	public List<BoardResponseDto> viewAllBoard() {
		List<BoardResponseDto> list = new ArrayList<BoardResponseDto>();
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT post_no,user_id,title,contents,admin_comment,is_commented,post_date,mod_date,is_notice "
					+ "FROM post ORDER BY post_date DESC";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int postNumber = rs.getInt(1);
				String userId =rs.getString(2);
				String title =rs.getString(3);
				String contents =rs.getString(4);
				String adminComment = rs.getString(5);
				boolean isCommented = rs.getBoolean(6);
				Timestamp postDate = rs.getTimestamp(7);
				Timestamp modDate = rs.getTimestamp(8);
				boolean isNotice =rs.getBoolean(9);
				
				BoardResponseDto board = new BoardResponseDto(postNumber, userId, title, contents, adminComment, isCommented, postDate, modDate, isNotice);
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return list;
	}
}

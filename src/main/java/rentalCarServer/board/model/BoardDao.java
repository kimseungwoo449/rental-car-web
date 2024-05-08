package rentalCarServer.board.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import rentalCarServer.user.model.UserResponseDto;
import rentalCarServer.util.DBManager;
import rentalCarServer.util.PasswordCrypto;

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

			while (rs.next()) {
				int postNumber = rs.getInt(1);
				String userId = rs.getString(2);
				String title = rs.getString(3);
				String contents = rs.getString(4);
				String adminComment = rs.getString(5);
				boolean isCommented = rs.getBoolean(6);
				Timestamp postDate = rs.getTimestamp(7);
				Timestamp modDate = rs.getTimestamp(8);
				boolean isNotice = rs.getBoolean(9);

				BoardResponseDto board = new BoardResponseDto(postNumber, userId, title, contents, adminComment,
						isCommented, postDate, modDate, isNotice);
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public BoardResponseDto findBoardByPostNumber(int postNumber) {
		BoardResponseDto board = null;
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT post_no,user_id,title,contents,admin_comment,is_commented,post_date,mod_date,is_notice "
					+ "FROM post WHERE `post_no` =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNumber);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String userId = rs.getString(2);
				String title = rs.getString(3);
				String contents = rs.getString(4);
				String adminComment = rs.getString(5);
				boolean isCommented = rs.getBoolean(6);
				Timestamp postDate = rs.getTimestamp(7);
				Timestamp modDate = rs.getTimestamp(8);
				boolean isNotice = rs.getBoolean(9);

				board = new BoardResponseDto(postNumber, userId, title, contents, adminComment, isCommented, postDate,
						modDate, isNotice);
			}
			return board;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return board;
	}

	public BoardResponseDto createBoard(BoardRequestDto boardDto) {
		BoardResponseDto board = null;
		try {
			conn = DBManager.getConnection();

			String sql = "INSERT INTO post(user_id,title,contents,is_notice)" + " VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			// sql 구문에 맵핑할 값 설정 <- column Index는 1부터! <- ?에 맵핑할것
			String userId = boardDto.getUserId();
			pstmt.setString(1, boardDto.getUserId());
			pstmt.setString(2, boardDto.getTitle());
			pstmt.setString(3, boardDto.getContents());
			pstmt.setBoolean(4, userId.equals("admin") ? true : false);

			pstmt.execute();
			board = findBoardByPostNumber(lastInsertPostNumber());
			return board;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return board;
	}

	private int lastInsertPostNumber() {
		int lastPostNumber = -1;
		try {
			String sql = "SELECT MAX(post_no) FROM post";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				lastPostNumber = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastPostNumber;
	}

	public boolean deleteBoardByPostNumber(int postNumber) {
		try {
			conn = DBManager.getConnection();

			String sql = "DELETE FROM post WHERE post_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNumber);
			pstmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return false;
	}
}

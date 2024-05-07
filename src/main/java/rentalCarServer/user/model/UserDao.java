package rentalCarServer.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import rentalCarServer.util.DBManager;
import rentalCarServer.util.PasswordCrypto;

public class UserDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static UserDao instance = new UserDao();

	private UserDao() {

	}

	public static UserDao getInstance() {
		return instance;
	}

	public UserResponseDto createUser(UserRequestDto userDto) {
		String id = userDto.getId();
		String email = userDto.getEmail();
		String residentNumber = userDto.getResidentNumber();
		String phone = userDto.getPhone();
		String password = userDto.getPassword();
		String gender = userDto.getGender();
		String name = userDto.getName();

		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO users(user_id,email,resident_no,phone,password,gender,name)"
					+ " VALUES(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			// sql 구문에 맵핑할 값 설정 <- column Index는 1부터! <- ?에 맵핑할것
			pstmt.setString(1, id);
			String tempEmail = email.equals("") ? null : userDto.getEmail();
			pstmt.setString(2, tempEmail);
			pstmt.setString(3, residentNumber);
			pstmt.setString(4, phone);
			pstmt.setString(5, PasswordCrypto.encrypt(password)); // 암호화
			pstmt.setString(6, gender);
			pstmt.setString(7, name);

			pstmt.execute();

			return new UserResponseDto(id, password, tempEmail, residentNumber, phone, gender, name);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return null;
	}

	public UserResponseDto login(UserRequestDto userDto) {
		UserResponseDto response = null;

		String id = userDto.getId();
		String password = userDto.getPassword();

		User target = findUserById(id);

		if (target == null)
			return response;

		String encryptedPassword = target.getPassword();

		if (PasswordCrypto.decrypt(password, encryptedPassword)) {
			response = new UserResponseDto(id, encryptedPassword, target.getEmail(), target.getResidentNumber(),
					target.getPhone(), target.getGender(), target.getName());
		}

		return response;
	}

	public UserResponseDto updateUser(UserRequestDto curUser, String inputPassword, String newPassword, String newEmail,
			String newPhone) {
		UserResponseDto response = null;
		String curId = curUser.getId();
		String curPassword = curUser.getPassword();
		String curEmail = curUser.getEmail();
		String curResidentNumber = curUser.getResidentNumber();
		String curPhone = curUser.getPhone();
		String curGender = curUser.getGender();
		String curName = curUser.getName();

		if (!PasswordCrypto.decrypt(inputPassword, curPassword)) {
			return response;
		}

		if (newPassword.equals("") || newPassword == null)
			newPassword = curPassword;
		else
			newPassword = PasswordCrypto.encrypt(newPassword);
		
		if(newPhone.length()==11) {
			newPhone = newPhone.substring(0,3)+"-"+newPhone.substring(3,7)+"-"+newPhone.substring(7,newPhone.length());
		}
		
		if (newEmail.equals("") || newEmail == null)
			newEmail = curEmail;
		
		
		
		if (newPhone.equals("") || newPhone == null)
			newPhone = curPhone;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "UPDATE users SET password=?,email=?,phone=? WHERE user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setString(2, newEmail);
			pstmt.setString(3, newPhone);
			pstmt.setString(4, curId);
			
			pstmt.execute();
			
			response = new UserResponseDto(curId, newPassword, newEmail, curResidentNumber, newPhone, curGender, curName);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		return response;
	}

	private User findUserById(String id) {
		User user = null;
		try {
			conn = DBManager.getConnection();
			// 쿼리할 준비
			String sql = "SELECT user_id,email,resident_no,phone,password,gender,name,reg_date, mod_date FROM users WHERE user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			// 쿼리 실행
			rs = pstmt.executeQuery();

			// 튜플 읽기
			while (rs.next()) {
				// database의 column index는 1부터 시작함
				String email = rs.getString(2);
				String residentNumber = rs.getString(3);
				String phone = rs.getString(4);
				String password = rs.getString(5);
				String gender = rs.getString(6);
				String name = rs.getString(7);
				Timestamp regDate = rs.getTimestamp(8);
				Timestamp modDate = rs.getTimestamp(9);

				user = new User(id, password, email, residentNumber, phone, gender, name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return user;
	}

}

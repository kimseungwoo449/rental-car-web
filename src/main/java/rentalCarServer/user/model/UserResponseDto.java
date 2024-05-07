package rentalCarServer.user.model;

public class UserResponseDto {
	private String id;
	private String password;
	private String email;
	private String residentNumber;
	private String phone;
	private String gender;
	private String name;

	public UserResponseDto(String id, String password, String email, String residentNumber, String phone, String gender,
			String name) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.residentNumber = residentNumber;
		this.phone = phone;
		this.gender = gender;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getResidentNumber() {
		return residentNumber;
	}

	public String getPhone() {
		return phone;
	}

	public String getGender() {
		return gender;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setResidentNumber(String residentNumber) {
		this.residentNumber = residentNumber;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setName(String name) {
		this.name = name;
	}

}

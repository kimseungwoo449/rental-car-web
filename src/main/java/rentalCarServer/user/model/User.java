package rentalCarServer.user.model;

public class User {
	private String id;
	private String password;
	private String email;
	private String residentNumber;
	private String phone;
	private String gender;
	private String name;
	
	public User() {
		
	}
	
	public User(String id, String password, String email, String residentNumber, String phone, String gender,
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
	
	
	
}

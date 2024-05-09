package rentalCarServer.car.model;

public class CarResponseDto {
	private String carNumber;
	private int categoryNumber;
	private String carName;
	private int carAge;
	private int passengersNumber;
	private String fuelType;
	private int hourlyRentalPrice;
	
	public CarResponseDto(String carNumber, int categoryNumber, String carName, int carAge, int passengersNumber,
			String fuelType, int hourlyRentalPrice) {
		super();
		this.carNumber = carNumber;
		this.categoryNumber = categoryNumber;
		this.carName = carName;
		this.carAge = carAge;
		this.passengersNumber = passengersNumber;
		this.fuelType = fuelType;
		this.hourlyRentalPrice = hourlyRentalPrice;
	}
	
	public CarResponseDto() {
		
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public int getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getCarAge() {
		return carAge;
	}

	public void setCarAge(int carAge) {
		this.carAge = carAge;
	}

	public int getPassengersNumber() {
		return passengersNumber;
	}

	public void setPassengersNumber(int passengersNumber) {
		this.passengersNumber = passengersNumber;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getHourlyRentalPrice() {
		return hourlyRentalPrice;
	}

	public void setHourlyRentalPrice(int hourlyRentalPrice) {
		this.hourlyRentalPrice = hourlyRentalPrice;
	}
	
	
}

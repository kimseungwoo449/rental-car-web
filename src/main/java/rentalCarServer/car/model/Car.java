package rentalCarServer.car.model;

public class Car {
	private String carNumber;
	private int categoryNumber;
	private String carName;
	private int carAge;
	private int passengersNumber;
	private String fuelType;
	private int hourlyRentalPrice;
	
	public Car(String carNumber, int categoryNumber, String carName, int carAge, int passengersNumber, String fuelType,
			int hourlyRentalPrice) {
		super();
		this.carNumber = carNumber;
		this.categoryNumber = categoryNumber;
		this.carName = carName;
		this.carAge = carAge;
		this.passengersNumber = passengersNumber;
		this.fuelType = fuelType;
		this.hourlyRentalPrice = hourlyRentalPrice;
	}
	
	public Car() {
		
	}

	public String getCarNumber() {
		return carNumber;
	}

	public int getCategoryNumber() {
		return categoryNumber;
	}

	public String getCarName() {
		return carName;
	}

	public int getCarAge() {
		return carAge;
	}

	public int getPassengersNumber() {
		return passengersNumber;
	}

	public String getFuelType() {
		return fuelType;
	}

	public int getHourlyRentalPrice() {
		return hourlyRentalPrice;
	}
	
	
}

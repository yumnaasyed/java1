package introJava;

public class Car {
	
	private String name;
	
	private int year;
	
	private int mileage;
	
	
	public Car(String name, int year, int mileage) {
		
		this.name = name;
		this.year = year;
		this.mileage = mileage;
	}
	
	public void drive(int distance) {
		
		mileage += distance;
	}
	
	public int worth() {
		
		int worth = 0;
		
		worth = (2022 - year - mileage) * mileage * 10;
		
		return worth;
	}
	
	public int getMileage() {
		
		return mileage;
	}
	
	public String toString() {
		return "This car is a " + name + " from " + year + " with mileage " + mileage;
	}
	
}
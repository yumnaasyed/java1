package introJava;

public class Garage {
	
	private Car[] cars;
	
	public Garage(int n) {
		
		cars = new Car[n];
	}
	
	public void addCar(int i, String name, int year, int mileage) {
		
			cars[i] = new Car(name, year, mileage);
	}
	
	public int totalWorth() {
		
		int totalWorth = 0;
		
		for (Car car : cars) {
			if (car != null) {
				totalWorth += car.worth();
			}
		}
		return totalWorth;
	}
	
	public double averageMileage() {
		
		int total = 0;
		int count = 0;
		
		for (Car car : cars) {
			if (car != null) {
				total += car.getMileage();
				count++;
			}
		}
		return total/count;
	}
	
	public void drive(int i, int n) {
		cars[i].drive(n);
	}
	
	public String toString() {
		
		for (Car car: cars) {
			return car.toString();
		}
	}
	
	
	
	public static void main(String[] args) {
		
		Garage g = new Garage(7);
		g.addCar(0, "porsche", 2010, 15000);
		g.addCar(2, "porsche", 2012, 150000);
		g.addCar(4, "audi", 2020, 6792234);
		g.addCar(5, "toyota", 2013, 1000000);
		g.addCar(6, "tesla", 2022, 507800);
		
		System.out.println(g.averageMileage());
		System.out.println(g.totalWorth());
		

	}
	
}
package introJava;

public class Chocolate extends Candy {
	
	private String flavor;
	private int milkyness;
	
	public Chocolate(String color, int size, String brand, int age, int price, String flavor, int milk) {
		super(color, size, brand, age, price);
		this.flavor = flavor;
		milkyness = milk;
	}
	
	public void changeColor(String n) {
		
		super.changeColor(n);
		
		flavor = getColor();
		
	}
	
	public void sweetness(int milk) {
		
		milkyness += milk/10;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {

	}
	
}
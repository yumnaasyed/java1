package introJava;

public class Candy {
	
	private String color;
	private int size;
	private String brand;
	private int age;
	private int price;
	
	public Candy(String color, int size, String brand, int age, int price) {
		
		this.color = color;
		this.size = size;
		this.brand = brand;
		this.age = age;
		this.price = price;
					
	}
	
	public String toString() {
		return "This candy is from " + brand + " and " + color + " It is " + size + " inches and " + age + " months old";
	}
	
	public void getSmaller(int timeEaten) {
		
		size -= timeEaten/15;
	}
	
	public void moreExpensive(int n) {
		if (size > 10) {
			price += n;
		}
	}
	
	public void getolder() {
		age++;
	}
	
	public void changeColor(String newColor) {
		color = newColor;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getSize() {
		return size;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public int getPrice() {
		return price;
	}
	
	
	public static void main(String[] args) {

	}
	
}
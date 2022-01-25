package introJava;

public class Human {
	
	private int age;
	private int shoeSize;
	private String name;
	private int height;
	
	public Human(int age, int shoeSize, String n, int height) {
		
		this.age = age;
		this.shoeSize = shoeSize;
		name = n;
		this.height = height;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int newAge) {
		age = newAge;
	}
	
	public void getOlder() {
		age++;
	}
	
	public void changeName(String newName) {
		name = newName;
	}
	
	public boolean canVote(int year) {
		
		if (year % 4 == 0 && age >= 18) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public String toString() {
		return "I am " + name + ", I am " + age + " years old. My shoe size is " + shoeSize + " and I am " + height + " inches tall.";
	}
	
	public void eat(int foodAmount) {
		
		height += foodAmount/100;
	}
	
	
	
	
	public static void main(String[] args) {
		
		Human Yumna = new Human(20, 6, "Yumna", 100);
		
		System.out.println(Yumna.canVote(2024));
		
		Yumna.eat(100);
		
		Yumna.getOlder();
		
		System.out.print(Yumna);
		
	}
	
}
package introJava;

public class darkChocolate extends Chocolate {
	
	private int bitterness;
	private boolean nuts;
	
	public darkChocolate(String color, int size, String brand, int age, int price, String flavor, int milk, int b, boolean nuts) {
		super(color, size, brand, age, price, flavor, milk);
		bitterness = b;
		this.nuts = nuts;
	}
	
	// takes out sweetness by adding bitterness
	public void sweetness(int b) {
		super.sweetness(b);
		
		bitterness += b/10;
	}
	
	public int getBitterness() {
		return bitterness;
	}
	
	
	
	public static void main(String[] args) {
		
		darkChocolate dc = new darkChocolate("pink", 10, "kinder", 2, 15, "strawberry", 5, 3, true);
		
		dc.sweetness(10);
		dc.getBitterness();
		dc.getAge();
		dc.changeColor("white");
		dc.getolder();

	}
	
}
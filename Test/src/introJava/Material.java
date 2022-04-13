package introJava;

public class Material {
	
	private String name;
	private int price;
	
	public Material(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
}
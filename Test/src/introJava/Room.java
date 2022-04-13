package introJava;

import java.util.ArrayList;

public class Room {
	
	private String name;
	private int height;
	private int length;
	private int width;
	private ArrayList<Material> materials;
	private ArrayList<Integer> amountMaterials;
	
	public Room(String name, int height, int length, int width, ArrayList<Material> materials, ArrayList<Integer> amountMaterials) {
		this.name = name;
		this.height = height;
		this.length = length;
		this.width = width;
		this.materials = materials;
		this.amountMaterials = amountMaterials;
	}
	
	public int volume() {
		return (height*length*width);
	}
	
	public int area() {
		return (length*width);
	}
	
	public int getPrice() {
		int total = 0;
		for (int i = 0; i < materials.size(); i++) {
			total += materials.get(i).getPrice()*amountMaterials.get(i);
		}
		return total;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getWidth() {
		return width;
	}
	
	public ArrayList<Material> getMaterial() {
		return materials;
	}
	
	public ArrayList<Integer> getAmountMaterials() {
		return amountMaterials;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setLength(int length) {
		this.length = length;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setMaterial(ArrayList<Material> materials) {
		this.materials = materials;
	}
	
	public void setAmountMaterial(ArrayList<Integer> amountMaterials) {
		this.amountMaterials = amountMaterials;
	}
	
	
	

}
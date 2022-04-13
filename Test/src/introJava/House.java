package introJava;

import java.util.ArrayList;

public class House {
	
	ArrayList<Room> rooms = new ArrayList<Room>();

	public House() {
	}
	
	public void addRoom(Room room) {
		rooms.add(room);
	}
	
	public int getPrice() {
		int total = 0;
		for (int i = 0; i < rooms.size(); i++) {
			total += rooms.get(i).getPrice();
		}
		return total;
	}
	
	public int volume() {
		int total = 0;
		for (int i = 0; i < rooms.size(); i++) {
			total += rooms.get(i).volume();
		}
		return total;
	}
	
	public int sqrFt() {
		int total = 0;
		for (int i = 0; i < rooms.size(); i++) {
			total += rooms.get(i).area();
		}
		return total;
	}
	
	public void setName(int i , String name) {
		rooms.get(i).setName(name);
	}
	
	public void setLength(int i, int length) {
		rooms.get(i).setLength(length);
	}

	public void setWidth(int i, int width) {
		rooms.get(i).setWidth(width);
	}
	
	public void setHeight(int i, int height) {
		rooms.get(i).setHeight(height);
	}
	
	public void setMaterial(int i, ArrayList<Material> materials) {
		rooms.get(i).setMaterial(materials);
	}
	
	public void setAmountMaterial(int i, ArrayList<Integer> amountMaterials) {
		rooms.get(i).setAmountMaterial(amountMaterials);
	}
	
}
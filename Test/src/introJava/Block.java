package introJava;

import java.awt.Color;
import java.awt.Graphics;

public class Block {
	
	private int x;
	private int y;
	private Color color;
	private int speed;
	
	public Block(int x, int y, Color color, int speed) {
		
		this.x = x;
		this.y = y;
		this.color = color;
		this.speed = speed;
	}
	
	public void draw(Graphics g) {
		
		g.setColor(Color.pink);
		
		g.drawRect(x, y, 25, 25);
		g.fillRect(x, y, 25, 25);
	}
	
	public void move() {
		
		y += speed;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Color getColor() {
		return color;
	}
	
	
	

	public static void main(String[] args) {

	}
	
}
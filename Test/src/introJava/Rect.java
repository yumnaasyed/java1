package introJava;

import java.awt.Color;
import java.awt.Graphics;

public class Rect extends Shape{
	
	private int width;
	private int height;
	
	public Rect(int startx, int starty, int width, int height) {
		
		super(startx, starty);
		this.width = width;
		this.height = height;
		
	}
	
	public void draw(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(getX(), getY(), width, height);
		
	}
	
	
}
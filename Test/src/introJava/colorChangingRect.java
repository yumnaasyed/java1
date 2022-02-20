package introJava;

import java.awt.Color;
import java.awt.Graphics;

public class colorChangingRect extends Shape {
	
	private int width;
	private int height;
	private int count = 0;
	
	public colorChangingRect(int startx, int starty, int width, int height) {
		
		super(startx, starty);
		this.width = width;
		this.height = height;
		
	}
	
	public void draw(Graphics g) {
		
		count++;
		
		g.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
		
		if (count % 5 == 0) {
			g.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
		}
		
		g.fillRect(getX(), getY(), width, height);
		
	}
	

	
	
}
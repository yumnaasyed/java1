package introJava;

import java.awt.Color;
import java.awt.Graphics;

public class Shape {
	private int x, y;
	
	// simple method - should just move the 
	// shape by the shift amounts
	public void move(int xshift, int yshift) {
		x += xshift;
		y += yshift;
	}
	
	// DON'T TOUCH BELOW CODE
	
	// takes a position as parameter
	public Shape(int startx, int starty) {
		x = startx;
		y = starty;
	}
	
	// a generic shape will just display text
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("I'm a Shape", x, y);	
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}

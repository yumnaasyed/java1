package spaceInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Laser extends Rectangle {

	public Laser(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	// moves laser along y axis based on input
	public void moveY(int distance) {
		// moves distance down the screen
		y += distance;
	}
	
	// draws image that corresponds with the player or alien
	public void draw(Graphics g, Color c) {
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}
}

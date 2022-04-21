package spaceInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Laser extends Rectangle {

	public Laser(int x, int y, int width, int height, int team) {
		super(x, y, width, height);
	}
	
	public void moveY(int distance) {
		y += distance;
	}
	
	public void draw(Graphics g, Color c) {
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}
}

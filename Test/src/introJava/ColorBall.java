package introJava;

import java.awt.Color;
import java.awt.Graphics;

public class ColorBall extends BouncingBall5{
	
	private int count = 0;
	
	public ColorBall(int startx, int starty, int startrad, int startxspeed, int startyspeed) {
		super(startx, starty, startrad, startxspeed, startyspeed, Color.MAGENTA);
	}
	
	public void draw(Graphics g) {
		
		count++;
		
		if (count % 100 == 0) {
			setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
		}
		super.draw(g);
	}
	
}
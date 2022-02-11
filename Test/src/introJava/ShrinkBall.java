package introJava;

import java.awt.Color;
import java.awt.Graphics;


public class ShrinkBall extends BouncingBall5{
	
	private int count = 0;
	
	public ShrinkBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
	}
	
	public void draw(Graphics g) {
		
		count++;
		
		if (count % 50 == 0) {
			setRad(getRad() - 1);
		}
		super.draw(g);
	}
	
}
package paintEditor;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Line extends Shape {
	
	
	public Line(int x,int y, int w, int h, Color c) {
		
		super(x, y, w, h, c);

	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.drawLine(x, y, width, height);
	}


	public Shape copy() {
		return null;
	}

	
	public boolean isOn(int x, int y) {
		
		if (!(x > this.x && y > this.y && x < this.x+width && y < this.y+height)) {
			return false;
		}
		
		
		double slope = (this.height)/((double)this.width);
		
		
		double y1 = slope * (x - this.x) + this.y;
		
		return Math.abs(y1 - y) <= 8;
		
	}

	// different for line bc of width restrictions
	public void resize(int x1, int y1, int x2, int y2) {
		width = x2;
		height = y2;
		
	}
	
	
}

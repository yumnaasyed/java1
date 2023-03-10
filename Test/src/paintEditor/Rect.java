package paintEditor;
import java.awt.Color;
import java.awt.Graphics;

public class Rect extends Shape {
	
	public Rect(int x,int y, int w, int h, Color c) {
		
		super(x, y, w, h, c);
		
	}
	
	public void draw(Graphics g) {
		// draws the actual rectangle
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}

	public Shape copy() {
		return null;
	}

	// for when the text box is clicked
	public boolean isOn(int x, int y) {
		return x > this.x && y > this.y && x < this.x+width && y < this.y+height;
	}

	public void resize(int x1, int y1, int x2, int y2) {
		
		// checks if distance is negative and sets new coordinates based on that
		if (y2 - y1 < 0) {
			height = Math.abs(y2 - y1);
			y = y2;
		}
		else {
			height = y2 - y1;
		}
				
		if (x2 - x1 < 0) {
			width = Math.abs(x2 - x1);
			x = x2;
		}
		else {
			width = x2 - x1;
		}
		
	}
		
}

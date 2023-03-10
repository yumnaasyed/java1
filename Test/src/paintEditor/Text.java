package paintEditor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Text extends Shape {
	
	public String text;
	
	public static final Font f = new Font("Serif", Font.PLAIN, 15);
	
	public Text(int x,int y, int w, int h, Color c, String text) {
		
		super(x, y, w, h, c);
		
		this.text = text;

	}
	
	public void draw(Graphics g) {
		// sets color and font for text and draws text
		g.setColor(c);
		g.setFont(f);
		g.drawString(text, x, y);
		Rectangle2D bounds = g.getFontMetrics().getStringBounds(text, g);
		width = (int) bounds.getWidth();
		height = (int) bounds.getHeight();
	}

	public Shape copy() {
		return null;
	}

	// for when the text box is clicked
	public boolean isOn(int x, int y) {
		return x > this.x && y < this.y && x < this.x+width && y > this.y-height;
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

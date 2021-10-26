package introJava;

// filler code for pong provided by Mr. David

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoopGraphicsFiller extends JPanel {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 1000, HEIGHT = 590;

	// defines what we want to happen anytime we draw the graphics
	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// call your methods here
		tenByTen(g);
		growingCircle(g);
		circlesRow(g, 10);
		checkerboard(g);
		rectangles(g);
	}
	
		
	// constant
	public void tenByTen(Graphics g) {
		
		g.setColor(Color.CYAN);
		
			for (int i = 0; i < 200; i+=20) {
				for (int j = 0; j < 200; j+=20) {
					g.fillOval(i, j, 20, 20);
				}
			}
		}
	
	// constant
	public void growingCircle(Graphics g) {
		
		g.setColor(Color.CYAN);
		
		for (int i = 0, r = 3; i < 30; i++) {
				
			g.fillOval(i*35, 100, r, r);
				
			if (i < 15) {
				r += 3;
			}
			else {
					r -= 3;
			}
		}
	}
			
	// linear
	public void circlesRow(Graphics g, int n) {
		
		g.setColor(Color.CYAN);
		
		for (int i = 0; i <= n; i++) {
			g.fillOval(i*20, 100, 10, 10);
		}
	}
	
	// constant
	public void checkerboard(Graphics g) {
		
		g.setColor(Color.CYAN);
		
		for (int i = 0; i <= 8; i++) {
			g.fillRect(i*20, i, 5, 160);
			g.fillRect(i, i*20, 160, 5);
		}
	}
	
	// constant
	public void rectangles(Graphics g) {
		
		for (int i = 0; i <= 10; i++) {
			
			int c1 = (int)(Math.random()*255);
			int c2 = (int)(Math.random()*255);
			int c3 = (int)(Math.random()*255);
			
			g.setColor(new Color(c1, c2, c3));
			
			g.fillRect(i*20, 100, 10, 10);
		}
	}
		
		
	
	

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual program.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
			
	
			// draws
			//repaint();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new LoopGraphicsFiller();
		
		
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public LoopGraphicsFiller() {
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		this.setFocusable(true);
		
		run();
	}
}
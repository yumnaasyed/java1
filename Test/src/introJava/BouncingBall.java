package introJava;

// a simple bouncing ball graphics example to practice our logic
// template provided by Mr. David, filled in by Yumna

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BouncingBall extends JPanel {
	
	// constants that are predefined and won't change as the program runs 
	// (you can feel free to change them though)
	private final int WIDTH = 600, HEIGHT = 600, WINDOW_HEIGHT = 650;
	private final int DIAM = 50;
	
	private final int BALLSIZE = 50;
	
	
	// put your instance variables here!
	
	private int ballx = 250;
	private int bally = 250;
	
	private int speedx = 2;
	private int speedy = 3;
	
	private int paddleWidth = 30;
	private int paddleHeight = 90;
	
	private int paddle1x = 0;
	private int paddle1y = 400;
	
	private int paddle2x = WIDTH - paddleWidth;
	private int paddle2y = 400;
	
	
	
	// move the ball according to its current velocity
	public void move_ball() {
		
		bally += speedy;
		ballx += speedx;
		
	}
	
	// make the ball bounce if need be
	public void check_collisions() {
		
		if (ballx > (WIDTH - BALLSIZE)) {
			speedx = speedx * -1;
		}
		
		else if (ballx < 0) {
			speedx = speedx * -1;
		}
	
		else if (bally > (HEIGHT - BALLSIZE)) {
			speedy = speedy * -1;
		}
		
		else if (bally < 0) {
			speedy = speedy * -1;
		}
		
	}
	
	// defines what we want to happen any time we draw the game
	public void paint(Graphics g) {
		// background color is white
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	
		
		// draw the ball - where do we want to draw it??
		//g.setColor(Color.blue);
		g.setColor(new Color(50,100,200));
		g.drawOval(ballx, bally, BALLSIZE, BALLSIZE);
		g.fillOval(ballx, bally, BALLSIZE, BALLSIZE);
		
		// your code goes here
		
		// draw the paddles
		
		g.setColor(new Color(50,100,200));
		g.drawRect(paddle1x, paddle1y, paddleWidth, paddleHeight);	
		g.fillRect(paddle1x, paddle1y, paddleWidth, paddleHeight);
		
		
		g.setColor(new Color(50, 100, 200));
		g.fillRect(paddle2x, paddle2y, paddleWidth, paddleHeight);
		g.fillRect(paddle2x, paddle2y, paddleWidth, paddleHeight);

	}
	
	/////////////////////////////////////////
	/////////////////////////////////////////
	
	// THE REST IS SETUP WHICH YOU ARE NOT RESPONSIBLE FOR
	
	// runs the game - note that this is actually a very simple method
	// because we do all the work in helper methods.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here 
		// it is ok because closing the graphics window will end the program
		while (true) {
	
			// updates the scene
			move_ball();
			check_collisions();
			
			// redraws the game
			repaint();
			
			//rests for a portion of a second
			try { Thread.sleep(10); } 
			catch (Exception ex) {}
		}
	}

	// very simple main method to get the game going
	public static void main(String[] args) {
		new BouncingBall(); 
	}
 
	// a constructor which sets up the layout and settings of our graphics.
	// do not play around with this method unless you know what you are doing!
	public BouncingBall() {
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		run();
	}
}
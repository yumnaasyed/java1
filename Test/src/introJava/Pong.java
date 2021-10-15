package introJava;

// Yumna Syed
// Help from Mr. Friedman
// 10/15/21
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
import java.util.Random;

public class Pong extends JPanel implements KeyListener {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 600, HEIGHT = 600, WINDOW_HEIGHT = 650;
	private final int PADDLE_WIDTH = 20, DIAM = 12, PADDLE_HEIGHT = 100;
	private final int PADDLE_SPEED = 4;
	private final int BLOCK_WIDTH = 25, BLOCK_HEIGHT = 80;

	
	// your instance variables here, I've given you a few 
	private boolean up1, down1, up2, down2; 		// booleans to keep track of paddle movement
	private boolean solo = false;
	
	
	// variables for ball location
	private int ballx = WIDTH/2;
	private int bally = WIDTH/2;
	
	
	// variables for ball speed in both directions
	private int speedx = 1;
	private int speedy = 2;
	

	// variables for paddles locations
	private int paddle1x = 0;
	private int paddle1y = WIDTH/2;
	
	private int paddle2x = WIDTH - PADDLE_WIDTH;
	private int paddle2y = WIDTH/2;
	
	
	// variables for starting scores
	private int p1score = 0;
	private int p2score = 0;
	
	
	// variables for blocks locations
	private int block1x = WIDTH/3;
	private int block1y = WIDTH/2;
	
	private int block2x = 400;
	private int block2y = WIDTH/2;
	
	// variable for block speed(y) because it only moves up and down
	private int blockSpeedy = 2;
	
	
	
	// moves the wall blocks
	public void move_blocks() {
		
		// moves block 1 upwards and block 2 downwards
		block1y -= blockSpeedy;
		block2y += blockSpeedy;
		
		
		// bounces ball off of wall blocks
		// FOUR CONDITIONS: only if ball is within current coordinates of a block
		if (ballx >= block1x && ballx <= block1x + BLOCK_WIDTH && bally >= block1y && bally <= block1y + BLOCK_HEIGHT) {
			speedx = speedx * -1;
		}
		if (ballx >= block2x && ballx <= block2x + BLOCK_WIDTH && bally >= block2y && bally <= block2y + BLOCK_HEIGHT) {
			speedx = speedx * -1;
		}
		
		
		// bounces wall block 1 off top of screen
		if (block1y <= 0) {
			blockSpeedy *= -1;
		}			
		// bounces wall block 1 off bottom of screen
		else if (block1y >= (HEIGHT - BLOCK_HEIGHT)) {
			blockSpeedy *= -1;
		}
		
		// bounces wall block 2 off top of screen
		if (block2y <= 0) {
			blockSpeedy *= -1;
		}	
		// bounces wall block 2 off bottom of screen
		else if (block2y >= (HEIGHT - BLOCK_HEIGHT)) {
			blockSpeedy *= -1;
		}
	}
	
	// this method moves the ball at each timestep
	public void move_ball() {
		
		// increases both coordinates of the ball by the speed
		bally += speedy;
		ballx += speedx;
	
	}
	
	// this method moves the paddles at each timestep
	public void move_paddles() {
		
		// moves paddle 1 up if the up arrow is pressed
		if (up1 == true) {
			paddle1y -= PADDLE_SPEED;
		}
		// moves paddle 1 down if the down arrow is pressed
		else if (down1 == true) {
			paddle1y += PADDLE_SPEED;
		}
		// moves paddle 2 up if key 'w' is pressed
		else if (up2 == true) {
			paddle2y -= PADDLE_SPEED;
		}
		// moves paddle 2 down if key 's' is pressed
		else if (down2 == true) {
			paddle2y += PADDLE_SPEED;
		}

		
		// paddle 2 turns into one player mode by following y coordinate of ball
		if (solo == true) {
			// starts moving down if ball is below paddle
			if (paddle2y < bally) {
				paddle2y += PADDLE_SPEED;
			}
			// starts moving up if ball if above paddle
			if (paddle2y > bally) {
				paddle2y -= PADDLE_SPEED;
			}
		}
	}
	
	// this method checks if there are any bounces to take care of,
	// and if the ball has reached a left/right wall it adds to 
	// the corresponding player's score
	public void check_collisions() {
		
		// the ball bounces if it hits bottom of screen
		if (bally > (HEIGHT - DIAM)) {
			speedy = speedy * -1;
		}
		// the ball bounces if it hits top of screen
		else if (bally < 0) {
			speedy = speedy * -1;
		}
		// the ball resets and score increases for paddle 1 if ball hits opposite side
		else if (ballx > (WIDTH - DIAM)) {
			ballx = WIDTH/2;
			bally = HEIGHT/2;
			p1score++;
		}
		// the ball resets and score increases for paddle 2 if ball hits opposite side
		else if (ballx < 0) {
			ballx = WIDTH/2;
			bally = HEIGHT/2;
			p2score++;
		}
		
		// the ball bounces off of paddle 1
		if (ballx <= PADDLE_WIDTH && bally >= paddle1y && bally <= paddle1y + PADDLE_HEIGHT) {
			speedx = speedx * -1;
		}
		// the ball bounces off of paddle 2
		else if (ballx >= (paddle2x - PADDLE_WIDTH) && bally >= paddle2y && bally <= paddle2y + PADDLE_HEIGHT) {
			speedx = speedx * -1;
		}
	}
	

	// defines what we want to happen anytime we draw the game
	// you simply need to fill in a few parameters here
	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(new Color(255,192,203));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		// draw the ball - where do we want to draw it??
		g.setColor(new Color(255,105,180));
		g.drawOval(ballx, bally, DIAM, DIAM);
		g.fillOval(ballx, bally, DIAM, DIAM);
		
		
		// draws/fills the paddles
		g.setColor(new Color(255,105,180));
		g.drawRect(paddle1x, paddle1y, PADDLE_WIDTH, PADDLE_HEIGHT);	
		g.fillRect(paddle1x, paddle1y, PADDLE_WIDTH, PADDLE_HEIGHT);
				
		g.setColor(new Color(255,105,180));
		g.fillRect(paddle2x, paddle2y, PADDLE_WIDTH, PADDLE_HEIGHT);
		g.fillRect(paddle2x, paddle2y, PADDLE_WIDTH, PADDLE_HEIGHT);
		
		
		// draws/fills the wall blocks
		g.setColor(new Color(255,75,75));
		g.drawRect(block1x, block1y, BLOCK_WIDTH, BLOCK_HEIGHT);	
		g.fillRect(block1x, block1y, BLOCK_WIDTH, BLOCK_HEIGHT);
				
		g.setColor(new Color(255,75,75));
		g.fillRect(block2x, block2y, BLOCK_WIDTH, BLOCK_HEIGHT);
		g.fillRect(block2x, block2y, BLOCK_WIDTH, BLOCK_HEIGHT);
		
		
		// writes the score of the game - you just need to fill the scores in
		Font f = new Font("Arial", Font.BOLD, 14);
		g.setFont(f);
		g.setColor(new Color(255,75,75));
		g.drawString("P1 Score: "+ p1score, WIDTH/5, 20);
		g.drawString("P2 Score: " + p2score, WIDTH*3/5, 20);
		
		// writes directions for both paddles
		Font directions = new Font("Arial", Font.BOLD, 14);
		g.setFont(directions);
		g.setColor(new Color(255,75,75));
		g.drawString("up and down arrows", WIDTH/6, 40);
		g.drawString("'w' and 's' keys", WIDTH*3/5, 40);
	}

	
	// defines what we want to happen if a keyboard button has 
	// been pressed - you need to complete this
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// changes paddle boolean to true if a certain key is pressed
		if (keyCode == KeyEvent.VK_DOWN) 
			down1 = true;
		
		if (keyCode == KeyEvent.VK_UP)
			up1 = true;

		if (e.getKeyChar() == 'w')
			up2 = true;
		
		if (e.getKeyChar() =='s')
			down2 = true;
			
		
		// turn 1-player mode on
		if (e.getKeyChar() == '1')
			solo = true;
			
		// turn 2-player mode on
		if (e.getKeyChar() == '2')
			solo = false;
	}

	// defines what we want to happen if a keyboard button
	// has been released - you need to complete this
	public void keyReleased(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// stops paddle motion and sets boolean back to false if a certain key is released
		if (keyCode == KeyEvent.VK_UP) 
			up1 = false;

		if (keyCode == KeyEvent.VK_DOWN) 
			down1 = false;
  
		if(e.getKeyChar() == 'w')
			up2 = false;
		
		if (e.getKeyChar() == 's')
			down2 = false;
	}
	
	
	// restarts the game, including scores
	public void restart() {
		
		// resets ball to middle
		ballx = WIDTH/2;
		bally = WIDTH/2;
		
		// resets paddle 1 to middle of left side
		paddle1x = 0;
		paddle1y = WIDTH/2;
		
		// resets paddle 2 to middle of right side
		paddle2x = WIDTH - PADDLE_WIDTH;
		paddle2y = WIDTH/2;
		
		// resets score for both sides to 0
		p1score = 0;
		p2score = 0;
		
	}

	
	
	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual game.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws the game
			repaint();
			
			// we move the ball, paddle, and check for collisions
			// every hundredth of a second
			move_ball();
			move_paddles();
			check_collisions();
			move_blocks();

			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new Pong();
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public Pong() {
		JFrame frame = new JFrame();
		JButton button = new JButton("restart");
		frame.setSize(WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.add(button, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart();
				Pong.this.requestFocus();
			}
		});
		this.addKeyListener(this);
		this.setFocusable(true);
		
		run();
	}
	
	// method does nothing
	public void keyTyped(KeyEvent e) {}
}
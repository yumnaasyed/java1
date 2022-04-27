package spaceInvaders;

// Yumna Syed
// Special Feature: shields on the screen which eliminate all lasers it collides with. 

// Space Invaders Filler Code by Mr. David

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class SpaceInvaders {
	
	// constants for various aspects of the game
	// feel free to change them to make the game harder/easier
	private final int WIDTH = 1000, HEIGHT = 700, NUMALIENS = 20, ALIENSPEED = 4, LASERSPEED = 7, PLAYERSPEED = 6,
			LASERWIDTH = 8, LASERHEIGHT = 25, PLAYERENEMYWIDTH = 50, PLAYERENEMYHEIGHT = 35, NUMSHIELDS = 3;
	
	// determines the difficulty. The closer to 1.0, the easier the game 
	private final double DIFFICULTY = .991;
	
	// our list of aliens
	private ArrayList<SpaceThing> aliens = new ArrayList<SpaceThing>();
	
	// list of barracades
	private ArrayList<SpaceThing> shields = new ArrayList<SpaceThing>();
	
	// our list of list of lasers for both the player and the aliens
	private ArrayList<Laser> alienLasers = new ArrayList<Laser>();
	private ArrayList<Laser> playerLasers = new ArrayList<Laser>();
	
	// the player
	private SpaceThing player;
	
	// the current speed of the player as well as their remaining lives and strength of shield at the start
	private int lives = 5, playerSpeed = 0;
	
	// booleans to keep track of the game's progress
	private boolean lost = false, paused = true;
	private boolean won = false;
	
	
	// move the aliens, the lasers, and the player. Loops aliens when necessary, 
	// and randomly shoots lasers from the aliens
	public void move() {
		
		// all objects only move if game is in play
		if (!won && !lost) {
		
			// loops through every alien
			for (int i = 0; i < aliens.size(); i++) {
				// moves aliens by speed
				aliens.get(i).moveX(ALIENSPEED);
				
				// checks if alien goes off screen on right side
				if (aliens.get(i).x > WIDTH) {
					// sets the alien back to the left
					aliens.get(i).setX(0);
					// shifts the y value of aliens down when they reappear on the left
					aliens.get(i).moveY(PLAYERENEMYHEIGHT);
				}
				
				// checks if difficulty is less than a random number from 0-1
				if (DIFFICULTY < Math.random()) {
					// shoots laser from this index's alien
					alienLasers.add(new Laser(aliens.get(i).x + PLAYERENEMYWIDTH/2, aliens.get(i).y + PLAYERENEMYHEIGHT/2, LASERWIDTH, LASERHEIGHT));
				}
			}
			
			// loops through every laser in player list
			for (int i = 0; i < playerLasers.size(); i++) {
				// shoots laser up by laser speed
				playerLasers.get(i).moveY(-1*LASERSPEED);
				
				// checks if laser exceeds the top of screen
				if (playerLasers.get(i).y < 0) {
					// removes the laser from list
					playerLasers.remove(i);
				}
			}
			
			// loops through every alien laser in list
			for (int i = 0; i < alienLasers.size(); i++) {
				// moves laser down by laser speed
				alienLasers.get(i).moveY(LASERSPEED);
				
				// checks if laser exceeds bottom of screen
				if (alienLasers.get(i).y > HEIGHT) {
					// removes laser from list
					alienLasers.remove(i);
				}
			}
			
			// moves player by player speed right and left
			player.moveX(playerSpeed);
			
			// checks if player exceeds the left
			if (player.x < 0) {
				// sets x value to 0
				player.x = 0;
			}
			// checks if player exceeds the right
			else if(player.x > WIDTH-PLAYERENEMYWIDTH) {
				// sets x value to width
				player.x = WIDTH-PLAYERENEMYWIDTH;
			}
		}
	}
	
	// check for collisions between alien lasers and the player
	// and between player lasers and the aliens
	// check if the aliens have reached the ground
	public void checkCollisions() {
		
		// loops through every alien laser in list
		for (int i = 0; i < alienLasers.size(); i++) {
			// checks if alien laser hits player
			if (alienLasers.get(i).intersects(player)) {
				// removes that laser from list
				alienLasers.remove(i);
				// decreases the player's lives
				lives--;
			}
			// if player has no more lives left
			if (lives == 0) {
				// pause the game and the player loses
				lost = true;
				paused = true;
			}
		}
		
		// loops through every alien
		for (int i = 0; i < aliens.size(); i++) {
			// loops through every player laser
			for (int j = 0; j < playerLasers.size(); j++) {
				// checks if player's laser hits alien
				if (playerLasers.get(j).intersects(aliens.get(i))) {
					// removes laser and alien from it's list
					playerLasers.remove(j);
					aliens.remove(i);
					// stops searching
					i--;
					break;
				}
			}
		}
		
		// loops through every alien in list
		for (int i = 0; i < aliens.size(); i++) {
			// checks if an alien had passed the player's y value
			if (aliens.get(i).y >= player.y) {
				// game is paused and player loses
				lost = true;
				paused = true;
			}
		}	
		
		// loops through every shield in list
		for (int i = 0; i < NUMSHIELDS; i++) {
			// loops through every laser in list of player
			for (int j = 0; j < playerLasers.size(); j++) {
				// checks if player's laser hits shield
				if (playerLasers.get(j).intersects(shields.get(i))) {
					// removes that laser
					playerLasers.remove(j);
					// stops searching
					i--;
					break; 
				}
			}
		}
		
		// loops through every shield in list
		for (int i = 0; i < NUMSHIELDS; i++) {
			// loops through every laser in list of aliens
			for (int j = 0; j < alienLasers.size(); j++) {
				// checks if alien laser hits shield
				if (alienLasers.get(j).intersects(shields.get(i))) {
					// removes laser
					alienLasers.remove(j);
					// stops searching
					i--;
					break;
				}
			}
		}
		
		// checks if list of aliens is empty
		if (aliens.isEmpty()) {
			// player wins and game is paused
			won = true;
			paused = true;
		}
	}
	
	// set up your variables, lists, etc here
	public void setup() {
		
		// sets up the player
		player = new SpaceThing(WIDTH/2, HEIGHT-(2*PLAYERENEMYHEIGHT), PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "Images/playerCannon.jpg");
		
		// adds shields to list to begin
		for (int i = 0; i < NUMSHIELDS; i++) {
			shields.add(new SpaceThing(i*WIDTH/NUMSHIELDS + (WIDTH/NUMSHIELDS/2), HEIGHT/2, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "Images/barracadeSpaceInvader.png"));
		}
		
		// adds the first line of aliens
		for (int i = 0; i < NUMALIENS/2; i++) {
				aliens.add(new SpaceThing(i*WIDTH/(NUMALIENS/2), 0, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "Images/alien.png"));
		}
		// adds second line of aliens below it
		for (int i = 0; i < NUMALIENS/2; i++) {
				aliens.add(new SpaceThing(i*WIDTH/(NUMALIENS/2), PLAYERENEMYHEIGHT, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "Images/alien.png"));
		}
	}
	
	// fires a player laser. if there are currently less than 4 lasers on the screen,
	// adds to the list. if there are 4 lasers on the screen, removes a laser and 
	// replaces it with this new one
	public void fireLaser() {
		
		// checks if there are less than 4 player lasers on screen
		if (playerLasers.size() < 4) {
			// adds new laser to list
			playerLasers.add(new Laser((int)player.getX() + PLAYERENEMYWIDTH/2, (int)player.getY(), LASERWIDTH, LASERHEIGHT));
		}
		
		// checks if there are 4 player lasers on screen
		else if (playerLasers.size() == 4) {
			// removes first and oldest laser in list
			playerLasers.remove(0);
			// adds new laser
			playerLasers.add(new Laser((int)player.getX() + PLAYERENEMYWIDTH/2, (int)player.getY(), LASERWIDTH, LASERHEIGHT));
		}
	}
	
	// draw a black background along with your lasers, aliens, and player here
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// draws alien lasers
		for (int i = 0; i < alienLasers.size(); i++) {
			alienLasers.get(i).draw(g, Color.BLUE);
		}
		// draws players lasers
		for (int i = 0; i < playerLasers.size(); i++) {
			playerLasers.get(i).draw(g, Color.RED);;
		}
		// draws space things
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		// draws shields
		for (int i = 0; i < NUMSHIELDS; i++) {
			shields.get(i).draw(g);
		}
		// draws the player
		player.draw(g);

		g.setColor(Color.red);
		g.drawString("Lives: "+lives, 15, 15);
		
		if (lost) 
			g.drawString("You lose", WIDTH/2-25, HEIGHT/2);
		if (won) 
			g.drawString("You win!", WIDTH/2-25, HEIGHT/2);
	}
	
	// ******* DON'T TOUCH BELOW CODE ************//
	
	public SpaceInvaders() {
		setup();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel canvas = new JPanel() {
			public void paint(Graphics g) {draw(g);}
		};
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "Left");
		canvas.getActionMap().put("Left", new LeftAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "LeftRelease");
		canvas.getActionMap().put("LeftRelease", new LeftReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), " ");
		canvas.getActionMap().put(" ", new SpaceAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "Right");
		canvas.getActionMap().put("Right", new RightAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "RightRelease");
		canvas.getActionMap().put("RightRelease", new RightReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0, false), "Pause");
		canvas.getActionMap().put("Pause", new PauseAction());
		frame.add(canvas);
		frame.setVisible(true);
		
		while (true) {
			if (!paused) {
				move();
				checkCollisions();
				frame.getContentPane().repaint();
			}
			try {Thread.sleep(20);} 
			catch (InterruptedException e) {}
		}
	}
	
	private class RightAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = PLAYERSPEED;
		}
	}
	private class LeftAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = -PLAYERSPEED;
		}
	}
	private class LeftReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = 0;
		}
	}
	private class RightReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = 0;
		}
	}
	private class SpaceAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			fireLaser();
		}
	}
	private class PauseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			paused = !paused;
		}
	}
	
	public static void main(String[] args) {
		new SpaceInvaders();
	}
}

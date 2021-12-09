package introJava;

import java.awt.Color;

//Yumna Syed
//Whack-A-Mole Project
// Filler code for Whack a Mole by Mr. Friedman
// extra feature is bombs which deduct points if clicked/losing feature is score is below 0

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class WhackAMoleFiller {

	// size of the display area
    private int windowWidth = 800, windowHeight = 600, textHeight = 35; 
    
    // all images used in game (mole, background, dirt, bomb, explosion)
    private Image moleImg, bgImg, dirtImg, bombImg, expImg;

    // constants for the number of moles, number of moles and bombs appearing at a time, and the 
    // time gap between new moles and bombs popping up (in milliseconds)
    private final int NUMMOLES = 10, NUMAPPEARING = 2, TIMESTEP = 1200;
    
    // locations of the moles and dirt
    private int[] x, y;
    // locations of bombs
    private int[] bx, by;
    
    // keeps track of which moles are popped up
    private boolean[] showing;
    // keeps track of which bomb shows on screen
    private boolean[] bombShowing;
    
    // keeps track of whether user has lost
    private boolean lost = false;
    
    // keeps track of score
    private int score;
    
    // mole dimensions
    private int moleHeight = 75;
    private int moleWidth = 75;
    //dirt dimensions
    private int dirtHeight = 50;
    private int dirtWidth = 50;
    // bomb dimensions
    private int bombHeight = 50;
    private int bombWidth = 50;
    
    
    // loads and defines variables
    public void setup() {
    	
    	// loads mole image
		moleImg = Toolkit.getDefaultToolkit().getImage("moleWhackAMole-removebg-preview.png");
		// loads background image
		bgImg = Toolkit.getDefaultToolkit().getImage("backgroundWhackAMole.jpeg");
		// loads dirt image
		dirtImg = Toolkit.getDefaultToolkit().getImage("moundComp-removebg-preview.png");
		// loads mouse image
		bombImg = Toolkit.getDefaultToolkit().getImage("bombImage-removebg-preview.png");
		// loads explosion image
		expImg = Toolkit.getDefaultToolkit().getImage("expBackground.jpg");
		
		// defines empty arrays for x and y coordinates of dirt and moles
		x = new int[NUMMOLES];
		y = new int[NUMMOLES];
		// defines empty arrays for x and y coordinates of bomb
		bx = new int[NUMMOLES];
		by = new int[NUMMOLES];
		
		// runs the time advance method
		timeAdvance();
		
		
		// assigns random numbers in range of grass for coordinates of moles and dirt and bomb
		for (int i = 0; i < NUMMOLES; i++) {
			
			// random coordinates for moles and dirt
			x[i] = (int)(Math.random()*(windowWidth-moleWidth));
			y[i] = (int)((Math.random()*((windowHeight*2/3)-(moleHeight+dirtHeight)))+windowHeight/3);
			
			// random coordinates for bomb
			bx[i] = (int)(Math.random()*(windowWidth-moleWidth));
			by[i] = (int)((Math.random()*((windowHeight*2/3)-(moleHeight+dirtHeight)))+windowHeight/3);
		}
    }

    //draws all images/text
    public void draw(Graphics g) {
    	
    	// gets font and color and size
    	Font f = new Font("Rockwell", Font.BOLD, 50);
		g.setFont(f);
		g.setColor(new Color(255,75,75));
    	
    	// draws images if the game is still playing
    	if(!lost) {
	    	// draws the background image at 0,0 with a size that will cover the entire display window
	        g.drawImage(bgImg, 0, 0, windowWidth, windowHeight, null);
	        
	        // draws moles and/or bomb if their index is true, draws dirt always
	        for (int i = 0; i < NUMMOLES; i++) {
	        	// draws mole
	        	if (showing[i] == true) {
	        		g.drawImage(moleImg, x[i], y[i], moleWidth, moleHeight, null);
	        	}
	        	// draws bomb
	        	if (bombShowing[i] == true) {
	        		g.drawImage(bombImg, bx[i], by[i], bombWidth, bombHeight, null);
	        	}
	        	// draws dirt
	        	g.drawImage(dirtImg, x[i], y[i] + dirtHeight, dirtWidth, dirtHeight, null);
	        }
    	}
    	// draws explosion and writes you lost if user lost game
    	else {
    		g.drawImage(expImg, 0, 0, windowWidth, windowHeight, null);
    		g.drawString("You Lost!", windowWidth/3, windowHeight/5);
    	}
    }


    // what you want to happen when the mouse is clicked
    public void click(int mouseX, int mouseY) {
    	
    	// if the mouse clicks the moles or bomb when they appear
    	for (int i = 0; i < NUMMOLES; i++) {
    		
    		// decreases score by 1000 and removes bomb from screen when bomb is clicked
    		if (mouseX > bx[i] && mouseX < bx[i] + bombWidth && mouseY > by[i] && mouseY < by[i] + bombHeight && bombShowing[i] == true) {
    			score -= 1000;
    			bombShowing[i] = false;
    		}
    		// increases score by 100 and removes mole from screen when mole clicked
    		if (mouseX > x[i] && mouseX < x[i] + moleWidth && mouseY > y[i] && mouseY < y[i] + moleHeight + dirtHeight && showing[i] == true) {
    			score += 100;
    			showing[i] = false;
    		}
    		// if score is less that 0 you lose
    		if (score < 0) {
    			lost = true;
    		}
    	}
    }
    
    // what you want to happen when the time for the current round ends
    public void timeAdvance() {
    	
    	// resets all moles to not showing
    	showing = new boolean[NUMMOLES];
    	// resets bombs to not showing
    	bombShowing = new boolean[NUMMOLES];
    	
    	// sets two random indexes to true so two moles appear
    	for (int i = 0; i < NUMAPPEARING; i++) {
    		showing[(int)(Math.random()*10)] = true;
    	}
    	// sets half the number of moles appearing to true so that many bombs appear
    	for (int i = 0; i < NUMAPPEARING/2; i++) {
    		bombShowing[(int)(Math.random()*10)] = true;
    	}
    }
    
    // reset the game
    public void reset() {
    	
    	// resets arrays
    	setup();
    	// resets score
    	score = 0;
    	// resets to say the user hasn't lost
    	lost = false;
    }

    
    

    // DO NOT TOUCH BELOW CODE //

    public WhackAMoleFiller() {
    	
    	setup();

        JFrame window = new JFrame();
        window.setTitle("Whack A Mole");
        window.setSize(windowWidth, windowHeight + textHeight);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JTextArea scoreDisplay = new JTextArea();
        scoreDisplay.setEditable(false);
        scoreDisplay.setText("\t\tScore: 0");
        
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
				 window.getContentPane().repaint();
			}
        });
        
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(windowWidth, textHeight));
        topPanel.add(resetButton);
        scoreDisplay.setBackground(topPanel.getBackground());
        
        topPanel.add(scoreDisplay);

        

        JPanel canvas = new JPanel() {
            public void paint(Graphics g) {
                draw(g);
                scoreDisplay.setText("\t\tScore: " + score);
            }
        };
        canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));

        canvas.addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {
                click(e.getX(), e.getY());
                window.getContentPane().repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        
        window.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                windowWidth = window.getWidth();
                windowHeight = window.getHeight() - textHeight;
                topPanel.setPreferredSize(new Dimension(windowWidth, textHeight));
                canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));
            }
        });

        container.add(topPanel);
        container.add(canvas);
        window.add(container);
        window.setVisible(true);
        canvas.revalidate();
        window.getContentPane().repaint();
        
        new Timer(TIMESTEP, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	timeAdvance();
            	window.getContentPane().repaint();
            }
        }).start();
    }
    

    public static void main(String[] args) {
        new WhackAMoleFiller();
    }

}
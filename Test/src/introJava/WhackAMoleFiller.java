package introJava;

//Yumna Syed
//Whack-A-Mole Project

// Filler code for Whack a Mole by Mr. Friedman

import java.awt.Dimension;
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
    
    // all images used in game (mole, background, dirt)
    private Image moleImg, bgImg, dirtImg;

    // constants for the number of moles, number of moles appearing at a time, and the 
    // time gap between new moles popping up (in milliseconds)
    private final int NUMMOLES = 10, NUMAPPEARING = 2, TIMESTEP = 2000;
    
    // locations of the moles
    private int[] x, y;
    
    // keeps track of which moles are popped up
    private boolean[] showing;
    
    // keeps track of score
    private int score;
    
    // mole dimensions
    private int moleHeight = 75;
    private int moleWidth = 75;
    //dirt dimensions
    private int dirtHeight = 50;
    private int dirtWidth = 50;
    
    
    public void setup() {
    	// loads mole image
		moleImg = Toolkit.getDefaultToolkit().getImage("moleWhackAMole-removebg-preview.png");
		// loads background image
		bgImg = Toolkit.getDefaultToolkit().getImage("backgroundWhackAMole.jpeg");
		// loads dirt image
		dirtImg = Toolkit.getDefaultToolkit().getImage("moundComp-removebg-preview.png");
		
		
		// defines empty arrays for x and y coordinates of dirt and moles
		x = new int[NUMMOLES];
		y = new int[NUMMOLES];
		// defines the entire array as false so no moles show
		showing = new boolean[NUMMOLES];
		
		// assigns random numbers in range of grass for coordinates of moles and dirt
		for (int i = 0; i < NUMMOLES; i++) {
			x[i] = (int)(Math.random()*(windowWidth-moleWidth));
			y[i] = (int)((Math.random()*((windowHeight*2/3)-(moleHeight+dirtHeight)))+windowHeight/3);
			
		}
    }

    public void draw(Graphics g) {
    	
    	// draws the background image at 0,0 with a size that will cover the entire display window
        g.drawImage(bgImg, 0, 0, windowWidth, windowHeight, null);
        
        // draws moles if their index is true, draws dirt always
        for (int i = 0; i < NUMMOLES; i++) {
        	if (showing[i] == true) {
        		g.drawImage(moleImg, x[i], y[i], moleWidth, moleHeight, null);
        	}
        	g.drawImage(dirtImg, x[i], y[i]+dirtHeight, dirtWidth, dirtHeight, null);
        }
        
        
    }


    // what you want to happen when the mouse is clicked
    public void click(int mouseX, int mouseY) {
    	
    	// your code here
    	
    	for (int i = 0; i < NUMMOLES; i++) {
    		if (mouseX > x[i] && mouseX < x[i] + moleWidth && mouseY > y[i] && mouseY < y[i] + moleHeight + dirtHeight && showing[i] == true) {
    			score += 100;
    			showing[i] = false;
    		}
    	}
  
    }
    
    // what you want to happen when the time for the current round ends
    public void timeAdvance() {
    	
    	// resets all moles to not showing
    	showing = new boolean[NUMMOLES];
    	
    	for(int i = 0; i < NUMAPPEARING; i++) {
    		showing[(int)(Math.random()*10)] = true;
    	}
    	
    }
    
    // reset the game
    public void reset() {
    	
    	// your code here
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
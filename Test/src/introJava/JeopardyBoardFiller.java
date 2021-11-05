package introJava;

// Yumna Syed
// November 4, 2021
// Help from Mr. Friedman

// Jeopardy Board: Click inside whichever box and your score will increase by the points inside given box. The color of the last box clicked is different.

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JeopardyBoardFiller {
	
	// the dimensions of the screen and the text
	private int gridWidth = 800, gridHeight = 600, textHeight = 50;
	
	// how many boxes go down and across screen(can be changed and screen adjusts)
	private final int NUMQUESTIONS = 5, NUMCATEGORIES = 6;
	
	// instance variables:
	
	// keeps track of score
	private int score = 0;
	
	// keeps track of which box across was clicked last, starting with none of them
	private int boxCategory = -1;
	// keeps track of which box in columns was clicked last, starting with none of them
	private int boxQuestion = -1;
	
	
	// draws screen and everything inside screen
	public void draw(Graphics g) {
		
		// how to draw your jeopardy board (categories going across, questions going down)
		
		// sets color(pink) and draws background
		g.setColor(new Color(255,192,203));
		g.fillRect(0, 0, gridWidth, gridHeight);
		
		
		// draws boxes across and down and writes text inside each with increasing points (based on NUMQUESTIONS and NUMCATEGORIES)
		for (int categories = 0; categories <= NUMCATEGORIES; categories++) {
			for (int questions = 0; questions <= NUMQUESTIONS; questions++) {
				
				// sets new color(dark pink) for the boxes and draws each box
				g.setColor(new Color(255,105,180));
				g.drawRect((gridWidth/NUMCATEGORIES) * categories, (gridHeight/NUMQUESTIONS) * questions, gridWidth/NUMCATEGORIES, gridHeight/NUMQUESTIONS);
				
				// sets blue as new color(for text) when a new box is clicked
				if (boxCategory == categories && boxQuestion == questions) {
					g.setColor(new Color(100,105,200));
				}
				// draws text inside each box
				g.drawString(100 * questions + 100 + "",((gridWidth/NUMCATEGORIES) * categories)+(gridWidth/NUMCATEGORIES)/2, ((gridHeight/NUMQUESTIONS) * questions)+(gridHeight/NUMQUESTIONS)/2);
			}
		}
	}
	
	
	// takes care of what happens when user clicks
	public void click(int mouseX, int mouseY) {
		
		// score increases by the points of wherever mouse is clicked
		score += mouseY/(gridHeight/NUMQUESTIONS) * 100 + 100;
		
		// changed to which box the mouse was last clicked in the categories rows
		boxCategory = mouseX/(gridWidth/NUMCATEGORIES);
		// changes to which box the mouse was last clicked in the questions columns
		boxQuestion = mouseY/(gridHeight/NUMQUESTIONS);
	}
	
		
	
	// DO NOT TOUCH BELOW CODE //
	
	public JeopardyBoardFiller() {
		
		JFrame window = new JFrame();
		window.setTitle("Jeopardy!");
		window.setSize(gridWidth, gridHeight + textHeight);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		JTextArea scoreDisplay = new JTextArea();
		scoreDisplay.setEditable(false);
		scoreDisplay.setText("\t\tScore: 0");
		
		JPanel canvas = new JPanel() {
			public void paint(Graphics g) {
				gridWidth = window.getWidth();
				gridHeight = window.getHeight() - textHeight;
				draw(g);
			}
		};
		canvas.setPreferredSize(new Dimension(gridWidth, gridHeight));
		
		canvas.addMouseListener(new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				click(e.getX(), e.getY());
				scoreDisplay.setText("\t\tScore: " + score);
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
		
		container.add(canvas);
		container.add(scoreDisplay);
		window.add(container);
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JeopardyBoardFiller();
	}

}

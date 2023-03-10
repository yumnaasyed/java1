package paintEditor;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JColorChooser;

public class SimpleGraphics extends JPanel  {
	
	// the width/height of window
	// final bc I didn't allow the window size to change
	private final int width = 800, height = 600;
	
	// booleans to track which buttons are pressed later on
	boolean rectCreated = false;
	boolean circleCreated = false;
	boolean lineCreated = false;
	boolean textCreated = false;
	
	boolean deleteUsed = false;
	boolean colorUsed = false;
	
	// default color
	Color startColor = Color.BLACK;
	
	private String shape;
	
	private String action;
	
	int startX, endX, startY, endY;
	
	private List<Shape> shapes = new ArrayList<Shape>();
 
	// this is where we do the graphics initializations
	public SimpleGraphics() {
		
		JFrame frame = new JFrame();
		
		frame.setSize(width, height);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(null);

		// rectangle button
		JButton rectButton = new JButton("Rectangle");
		rectButton.addActionListener(new ActionListener() {
			
			// what we want to happen when the user clicks this button
			public void actionPerformed(ActionEvent e) {
				shape = "rectangle";
				// checks which button needs to be drawn
				rectCreated = true;
				circleCreated = false;
				lineCreated = false;
				textCreated = false;
				deleteUsed = false;
				colorUsed = false;
			}
		});
		rectButton.setBounds(50,10,90,50);
		frame.add(rectButton);
		
		
		// circle button
		JButton circleButton = new JButton("Circle");
		circleButton.addActionListener(new ActionListener() {
			
			// what we want to happen when the user clicks this button
			public void actionPerformed(ActionEvent e) {
				shape = "circle";
				// checks which button needs to be drawn
				rectCreated = false;
				circleCreated = true;
				lineCreated = false;
				textCreated = false;
				deleteUsed = false;
				colorUsed = false;
			}
		});;
		circleButton.setBounds(170,10,70,50);
		frame.add(circleButton);
		
		
		// line button
		JButton lineButton = new JButton("Line");
		lineButton.addActionListener(new ActionListener() {
			
			// what we want to happen when the user clicks this button
			public void actionPerformed(ActionEvent e) {
				shape = "line";
				// checks which button needs to be drawn
				rectCreated = false;
				circleCreated = false;
				lineCreated = true;
				textCreated = false;
				deleteUsed = false;
				colorUsed = false;
			}
		});;
		lineButton.setBounds(270,10,70,50);
		frame.add(lineButton);
		
		
		// text button
		JButton textButton = new JButton("Text");
		textButton.addActionListener(new ActionListener() {
			
			// what we want to happen when the user clicks this button
			public void actionPerformed(ActionEvent e) {
				action = "text";
				// checks which button needs to be drawn
				rectCreated = false;
				circleCreated = false;
				lineCreated = false;
				textCreated = true;
				deleteUsed = false;
				colorUsed = false;
			}
		});;
		textButton.setBounds(380,10,70,50);
		frame.add(textButton);
		// creates textbox variable so we can use it for the user input later
	
	    JTextField textField = new JTextField();
	    textField.setPreferredSize(new Dimension(100, 25));
        textField.setMaximumSize(textField.getPreferredSize());
        textField.setText("Text Content");
        textField.setVisible(true);
        textField.setSize(textField.getPreferredSize());
        
		
		// delete button
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			
			// what we want to happen when the user clicks this button
			public void actionPerformed(ActionEvent e) {
				action = "delete";
				// checks which button needs to be drawn
				rectCreated = false;
				circleCreated = false;
				lineCreated = false;
				textCreated = false;
				deleteUsed = true;
				colorUsed = false;
			}
		});;
		deleteButton.setBounds(480,10,70,50);
		frame.add(deleteButton);
		
		
		// choose color button
		JButton colorButton = new JButton("Color");
		colorButton.addActionListener(new ActionListener() {
			
			// what we want to happen when the user clicks this button
			public void actionPerformed(ActionEvent e) {
				action = "color";
				// checks which button needs to be drawn
				rectCreated = false;
				circleCreated = false;
				lineCreated = false;
				textCreated = false;
				deleteUsed = false;
				colorUsed = true;
				
				// lets user choose unique color
				startColor = JColorChooser.showDialog(null, "Choose a Color!", startColor);
			}
		});;
		colorButton.setBounds(590,10,70,50);
		frame.add(colorButton);
		
		// draws text box on screen
		textField.setLocation(365, 60);
		frame.add(textField);
		
		
		this.addMouseMotionListener(new MouseMotionAdapter() { 
			
			// so that when you drag the mouse the shape moves with it
			public void mouseDragged (MouseEvent e) {
				
				if (rectCreated || circleCreated || lineCreated || textCreated) {
					shapes.get(shapes.size()-1).resize(startX, startY, e.getX(), e.getY());
					
					repaint();
				}
			}
		});
		
		this.addMouseListener(new MouseListener() {

			public void mousePressed(MouseEvent e) {
				startX = e.getX();
				startY = e.getY();
				
				// draws rectangle if button is pressed
				if (rectCreated == true) {
					shapes.add(new Rect(e.getX(), e.getY(), width, height, startColor));
				}
				
				// draws circle is button is pressed
				if (circleCreated == true) {
					shapes.add(new Circle(e.getX(), e.getY(), width, height, startColor));
				}
				
				// draws line if button is pressed
				if (lineCreated == true) {

					shapes.add(new Line(e.getX(), e.getY(), width, height, startColor));
				}
				
				// draws text as shape
				if (textCreated == true) {
					shapes.add(new Text(e.getX(), e.getY(), width, height, startColor, textField.getText()));
				}
				
				// deletes whichever shape is pressed
				if (deleteUsed == true) {
					int x = e.getX(), y = e.getY();
					// uses streams to filter clicked shapes
					shapes = shapes.stream().filter(s -> {
						
						return !s.isOn(x, y);
					}).collect(Collectors.toList());
				}
				repaint();
			}

			public void mouseReleased(MouseEvent e) {
				endX = e.getX();
				endY = e.getY();	
			}	
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}	
			public void mouseClicked(MouseEvent e) {}
		});
		
		
		this.setBounds(0, 100, width, height);
		
		frame.add(this);
		
		frame.setLocationRelativeTo(null);
		
		frame.setResizable(false);
		
		frame.setVisible(true);
		
		this.setFocusable(true);
		
		// get our functionality going (if we have any)
		run();
	}

	// This is what we want the code to do as the panel is open.
	public void run() {

		// note - I don't have anything besides graphics setup in
		// this code, so my program won't actually 'do' anything.
		// If I wanted to 'do something', this is where I would do that
	}
	
	
	// If I want to update my original graphics display, I call repaint()
	public void paint(Graphics g) {
	
		// draws all shapes
		for (Shape s : shapes) {
			s.draw(g);
		}
	}
	
	// very simple main method - create our graphics object
	public static void main(String[] args) {
		new SimpleGraphics(); 
	}
}

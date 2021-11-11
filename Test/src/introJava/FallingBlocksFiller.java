package introJava;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FallingBlocksFiller extends JPanel {
	
	private int WIDTH = 800, HEIGHT = 600, NUMBLOCKS = 50;

	// instance variables (what kind of data structure should we use?)
	
	private int blocksWidth = 20;
	private int blocksHeight = 20;
	
	private int speedBlock = 5;
	
	// your code here
	
	private int[] blocksX = new int[NUMBLOCKS];
	private int[] blocksY = new int[NUMBLOCKS];
	
	// fills in your arrays with random x and y values
	public void initializeArrays() {
		
		// your code here
		for(int oneBlock = 0; oneBlock < NUMBLOCKS; oneBlock++) {
			blocksX[oneBlock] = (int)(Math.random()*WIDTH);
			blocksY[oneBlock] = (int)(Math.random()*HEIGHT);
		}
	}
	
	// change your arrays here to make the blocks move
	public void moveblocks() {

		for (int oneBlockY = 0; oneBlockY < NUMBLOCKS; oneBlockY++) {
			blocksY[oneBlockY] += speedBlock;
			if (blocksY[oneBlockY] >= HEIGHT) {
				blocksY[oneBlockY] = 0;
			}
		}
	}
	
	// change the last part of this method!
	public void paint(Graphics g) {
		// give a white background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// color the rectangles blue - you can change this
		g.setColor(Color.pink);
		
		// draw your rectangles here!
		for (int blocks = 0; blocks < NUMBLOCKS; blocks++) {
			g.drawRect(blocksX[blocks], blocksY[blocks], blocksWidth, blocksHeight);
			g.fillRect(blocksX[blocks], blocksY[blocks], blocksWidth, blocksHeight);
		}
		
	}
	
	
	
	// ******** DON'T TOUCH BELOW CODE ***************
	
	// don't touch this method!
	public FallingBlocksFiller() {
		initializeArrays();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);

		while (true) {
			moveblocks();
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			WIDTH = frame.getSize().width;
			HEIGHT = frame.getSize().height;
		}
	}

	// don't touch this method!
	public static void main(String[] args) {
		new FallingBlocksFiller();
	}

}
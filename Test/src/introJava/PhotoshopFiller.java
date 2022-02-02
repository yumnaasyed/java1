package introJava;
// Yumna Syed
// 1/28/22
// help from Mr. Friedman
// Photoshop program that can run several manipulations on 
// an image
// filler code by Mr. David
// extra features: black and white filter, crop method

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class PhotoshopFiller extends Component {

	// the name of the output file. will be determined by which methods are called
    private String outputName;
    
    // the 2d array of colors representing the image
    private Color[][] pixels;
    
    // the width and height of the image 
    private int w,h;
    

    // this method increases each color's rgb value by a given amount.
    // don't forget that rgb values are limited to the range [0,255]
    public void brighten(int amount) {
        outputName = "brightened_" + outputName;
        
        // two for loops to go through each pixel
        
        // goes down column
        for (int i = 0; i < pixels.length; i ++) {
        	
        	// goes across each row
        	for (int j = 0; j < pixels[i].length; j++) {
        		
        		// adds brightness amount to each pixel's red, green and blue value
        		//red
        		int r = pixels[i][j].getRed() + amount;
        		// green
        		int g = pixels[i][j].getGreen() + amount;
        		// blue
        		int b = pixels[i][j].getBlue() + amount;
        		
        		// if red value is over 255 after adding brightness value, make it 255
        		if (r > 255) r = 255;
        		// if red value is less than 0 after adding negative number, make it 0
        		else if (r < 0) r = 0;
        		
        		// if green value is over 255 after adding brightness value, make it 255
        		if (g > 255) g = 255;
        		// if green value is less than 0 after adding negative number, make it 0
        		else if (g < 0) g = 0;
        		
        		// if blue value is over 255 after adding brightness value, make it 255
        		if (b > 255) b = 255;
        		// if blue value is less than 0 after adding negative number, make it 0
        		else if (b < 0) b = 0;
        		
        		// sets each pixels color to the new value after adding brightness amount
        		pixels[i][j] = new Color(r, g, b);
        	}
        }
    }
    
    // flip an image either horizontally or vertically.
    public void flip(boolean horizontally) {
        outputName = (horizontally?"h":"v") + "_flipped_" + outputName;
        
        // if user wants image flipped horizontally
        if (horizontally) {
        	
        	// first for loop to go down column
        	for (int i = 0; i < pixels.length; i++) {
        		
        		// for loop to go halfway across the image
        		for (int j = 0; j < pixels[i].length/2; j++) {
        			
        			// sets temporary color for current pixel
        			Color temp = pixels[i][j];
        			
        			// sets current pixel to opposite side's pixel color
        			pixels[i][j] = pixels[i][pixels[i].length - j -1];
        			
        			// sets opposite side's pixel to current pixel's color
        			pixels[i][pixels[i].length - j -1] = temp;
        		}
        	}
        }
        
        // if user wants image flipped vertically
        else {
        	
        	// goes down the rows for half the length of the image
        	for (int i = 0; i < pixels.length/2; i++) {
        		
        		// creates array for half the column 
        		Color[] temp = pixels[i];
        		
        		// sets the array to the pixel's colors on the opposite side
        		pixels[i] = pixels[pixels.length - i - 1];
        		
        		// sets the array on the opposite side to the current array of colors.
        		pixels[pixels.length - i - 1] = temp;
        	}
        }
    }
    
    // negates an image
    // to do this: subtract each pixel's rgb value from 255 
    // and use this as the new value
    public void negate() {
        outputName = "negated_" + outputName;
        
        // two for loops to go through each pixel
        for (int i = 0; i < pixels.length; i ++) {
        	
        	for (int j = 0; j < pixels[i].length; j++) {
        		
        		// subtracts pixels red, green, and blue value from 255 to darken colors
        		// red
        		int r = 255 - pixels[i][j].getRed();
        		// green
        		int g = 255 - pixels[i][j].getGreen();
        		// blue
        		int b = 255 - pixels[i][j].getBlue();
        		
        		// sets current pixel to have the new rgb value
        		pixels[i][j] = new Color(r, g, b);
        	}
        }
    }
    
    // this makes the image 'simpler' by redrawing it using only a few colors
    // to do this: for each pixel, find the color in the list that is closest to
    // the pixel's rgb value. 
    // use this predefined color as the rgb value for the changed image.
    public void simplify() {
    
    		// the list of colors to compare to. Feel free to change/add colors
    		Color[] colorList = {Color.BLUE, Color.RED,Color.ORANGE, Color.MAGENTA,
                Color.BLACK, Color.WHITE, Color.GREEN, Color.YELLOW, Color.CYAN};
        outputName = "simplified_" + outputName;
        
        // two for loops to go through each pixel
        for (int i = 0; i < pixels.length; i++) {
        	
        	for (int j = 0; j < pixels[i].length; j++) {
        		
        		// keeps track of whichever color is closest to the pixel's color
        		// starts with the first color in list
        		Color closest = colorList[0];
        		
        		// keeps track of the smallest distance a pixel has to each color on the color list
        		// starts at first index in list
        		double min = distance(pixels[i][j], colorList[0]);
        		
        		// compares each pixel to each color in color list
        		for (int z = 1; z < colorList.length; z++) {
        			
        			// checks distance from pixel to current color list index and compares to min distance
        			if(distance(pixels[i][j], colorList[z]) < min) {
        				
        				// sets minimum to the current distance its checking
        				min = distance(pixels[i][j], colorList[z]);
        				// sets the closest color to the current color its checking
        				closest = colorList[z];
        			}
        		}
        		// sets each pixel to the closest color to original color value
        		pixels[i][j] = closest;
        	}
        }
    }
    
    // optional helper method (recommended) that finds the 'distance' 
    // between two colors.
    // use the 3d distance formula to calculate
    public double distance(Color c1, Color c2) {
    		
    	// 3d distance formula
    	return Math.sqrt((c2.getRed() - c1.getRed())*(c2.getRed() - c1.getRed()) + (c2.getGreen() - c1.getGreen())*(c2.getGreen() - c1.getGreen()) + (c2.getBlue() - c1.getBlue())*(c2.getBlue() - c1.getBlue()));
    }
    
    // this blurs the image
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values 
    // with the current pixel's own rgb value. 
    // divide this sum by 9, and set it as the rgb value for the blurred image
    // surrounding pixels indeces:
 	// (i, j) -> (i-1, j) (i+1, j) (i, j-1) (i, j+1) (i-1, j+1) (i+1, j+1) (i-1, j-1) (i+1, j-1)
    public void blur() {
		outputName = "blurred_" + outputName;
		
		// two for loops to go through each pixel except the bordering pixels
		for (int i = 1; i < pixels.length-1; i++) {
			
			for (int j = 1; j < pixels[i].length-1; j++) {
				
				// variables to keep track of sum of each color of pixels around current pixel
				// red
				int rSum = 0;
				// green
				int gSum = 0;
				// blue
				int bSum = 0;
				
				// adds sum of each color of each pixel surrounding current pixel and current pixel's color
				// red
				rSum += pixels[i][j].getRed() + pixels[i-1][j].getRed() + pixels[i+1][j].getRed() + pixels[i][j-1].getRed() + pixels[i][j+1].getRed() + pixels[i+1][j+1].getRed() + pixels[i-1][j-1].getRed() + pixels[i-1][j+1].getRed() + pixels[i+1][j-1].getRed();
				// green
				gSum += pixels[i][j].getGreen() + pixels[i-1][j].getGreen() + pixels[i+1][j].getGreen() + pixels[i][j-1].getGreen() + pixels[i][j+1].getGreen() + pixels[i+1][j+1].getGreen() + pixels[i-1][j-1].getGreen() + pixels[i-1][j+1].getGreen() + pixels[i+1][j-1].getGreen();
				// blue
				bSum += pixels[i][j].getBlue() + pixels[i-1][j].getBlue() + pixels[i+1][j].getBlue() + pixels[i][j-1].getBlue() + pixels[i][j+1].getBlue() + pixels[i+1][j+1].getBlue() + pixels[i-1][j-1].getBlue() + pixels[i-1][j+1].getBlue() + pixels[i+1][j-1].getBlue();
				
				
				// changes the current pixels red, green and blue color to the average of the sum of surrounding pixel's color
				pixels[i][j] = new Color(rSum/9, gSum/9, bSum/9);
			}
		}
	}
    
    // this highlights the edges in the image, turning everything else black. 
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values. 
    // now, multiply the current pixel's rgb value by 8, then subtract the sum.
    // this value is the rgb value for the 'edged' image
    public void edge() {
        outputName = "edged_" + outputName;

        // creates 2d array size of image full of nulls
        Color[][] temp = new Color[pixels.length][pixels[0].length];
        
        // two for loops to go through each pixel except the bordering pixels
        for (int i = 1; i < pixels.length-1; i++) {
        	
			for (int j = 1; j < pixels[i].length-1; j++) {
				
				// tracks sum of colors of pixels surrounding current pixel
				// red
				int rSum = 0;
				// green
				int gSum = 0;
				// blue
				int bSum = 0;
				
				// adds sum of each color of each pixel surrounding current pixel
				// red
				rSum += pixels[i-1][j].getRed() + pixels[i+1][j].getRed() + pixels[i][j-1].getRed() + pixels[i][j+1].getRed() + pixels[i+1][j+1].getRed() + pixels[i-1][j-1].getRed() + pixels[i-1][j+1].getRed() + pixels[i+1][j-1].getRed();
				// green
				gSum += pixels[i-1][j].getGreen() + pixels[i+1][j].getGreen() + pixels[i][j-1].getGreen() + pixels[i][j+1].getGreen() + pixels[i+1][j+1].getGreen() + pixels[i-1][j-1].getGreen() + pixels[i-1][j+1].getGreen() + pixels[i+1][j-1].getGreen();
				// blue
				bSum += pixels[i-1][j].getBlue() + pixels[i+1][j].getBlue() + pixels[i][j-1].getBlue() + pixels[i][j+1].getBlue() + pixels[i+1][j+1].getBlue() + pixels[i-1][j-1].getBlue() + pixels[i-1][j+1].getBlue() + pixels[i+1][j-1].getBlue();
				
				// subtracts the sum of surrounding pixels from the current pixel's RGB value times 8
				// red
				rSum = pixels[i][j].getRed()*8 - (rSum);
				// green
				gSum = pixels[i][j].getGreen()*8 - (gSum);
				// blue
				bSum = pixels[i][j].getBlue()*8 - (bSum);
				
				// if red value is over 255 after adding brightness value, make it 255
        		if (rSum > 255) rSum = 255;
        		// if red value is less than 0 after adding negative number, make it 0
        		else if (rSum < 0) rSum = 0;
        		
        		// if green value is over 255 after adding brightness value, make it 255
        		if (gSum > 255) gSum = 255;
        		// if green value is less than 0 after adding negative number, make it 0
        		else if (gSum < 0) gSum = 0;
        		
        		// if blue value is over 255 after adding brightness value, make it 255
        		if (bSum > 255) bSum = 255;
        		// if blue value is less than 0 after adding negative number, make it 0
        		else if (bSum < 0) bSum = 0;
				
        		// sets the temp 2d array's index to the new RGB values from the image's same index
				temp[i][j] = new Color(rSum, gSum, bSum);
			}
        } 
        // sets the temp image to the original image
        pixels = temp;
        
        // makes the bordering pixel's colors black instead of null
        
        // goes across the length of the image
        for (int i = 0; i < pixels[0].length; i++) {
        	
        	// sets the top row to black
        	pixels[0][i] = new Color (0, 0, 0);
        	// sets bottom row to black
        	pixels[pixels.length-1][i] = new Color (0, 0, 0);
        }
        
        // goes down the height of the image
        for (int i = 0; i < pixels.length; i++) {
        	
        	// sets first column to black
        	pixels[i][0]= new Color (0, 0, 0);
        	// sets last column to black
        	pixels[i][pixels[0].length-1] = new Color (0, 0, 0);
        }
    }
    
    // turns the entire image black and white
    public void blackWhite() {
    	
    	outputName = "blackWhite_" + outputName;
    	
    	// two for loops to go through each pixel
    	for (int i = 0; i < pixels.length; i++) {
        	
        	for (int j = 0; j < pixels[i].length; j++) {
        	
        		// checks if the pixels color is closer to black
        		if ((distance(pixels[i][j], Color.BLACK)) < (distance(pixels[i][j], Color.WHITE))) {
        			
        			// changes pixels color to black
        			pixels[i][j] = Color.BLACK;
        		}
        		
        		// if pixels color is closer to white or right in the middle
        		else {
        			
        			// changes pixels color to white
        			pixels[i][j] = Color.WHITE;
        		}
        	}
        }
    }
    
    // crops square based on user's input for dimensions (dimension x dimension)
    // turns rest of image white
    // starts at top left corner
    public void crop(int dimension) {
    	
    	outputName = "cropped_" + outputName;
    	
    	// temp 2d array to add certain pixels colors to, others stay white
    	Color[][] cropped = new Color[pixels.length][pixels[0].length];
    	
    	// two for loops to go through each pixel
    	for (int i = 0; i < cropped.length; i++) {
    		
    		for (int j = 0; j < cropped[0].length; j++) {
    			
    			// checks if i and j are still within the dimension x dimension range
    			if (i < dimension && j < dimension) {
    				
    				// adds the original images pixel colors to cropped temp 2d array
    				cropped[i][j] = pixels[i][j];
    			}
    			
    			// if i and j are beyond the cropped range
    			else {
    				
    				// turns the pixels to the color white
    				cropped[i][j] = Color.WHITE;
    			}
    		}
    	}
    	// sets the image to the temporary cropped image
    	pixels = cropped;
    }
    
    
    
    
    // *************** DON'T MESS WITH THE BELOW CODE **************** //
    
    // feel free to check it out, but don't change it unless you've consulted 
    // with Mr. David and understand what the code's doing
    
    

    public void run() {
    	JFileChooser fc = new JFileChooser();
//		File workingDirectory = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+ "Images");
//		fc.setCurrentDirectory(workingDirectory);
		fc.showOpenDialog(null);
		File my_file = fc.getSelectedFile();
		if (my_file == null)
			System.exit(-1);
		System.out.println("here");
		
		// reads the image file and creates our 2d array
        BufferedImage image;
		try {
			image = ImageIO.read(my_file);
		
	        BufferedImage new_image = new BufferedImage(image.getWidth(),
	                        image.getHeight(), BufferedImage.TYPE_INT_ARGB);
	        create_pixel_array(image);
			outputName = my_file.getName();
			
			// runs the manipulations determined by the user
			System.out.println("Enter the manipulations you would like to run on the image.\nYour "
					+ "choices are: brighten, flip, negate, blur, edge, simplify, blackWhite, or crop.\nEnter each "
					+ "manipulation you'd like to run, then type in 'done'.");
			Scanner in = new Scanner(System.in);
			String action = in.next().toLowerCase();
			while (!action.equals("done")) {
	    			try {
		    			if (action.equals("brighten")) {
		    				System.out.println("enter an amount to increase the brightness by");
		    				int brightness = in.nextInt();
		        			Method m = getClass().getDeclaredMethod(action, int.class);
		        			m.invoke(this, brightness);
		    			}
		    			else if (action.equals("flip")) {
		    				System.out.println("enter \"h\" to flip horizontally, anything else to flip vertically.");
		        			Method m = getClass().getDeclaredMethod(action, boolean.class);
		        			m.invoke(this, in.next().equals("h"));
		    			}
		    			else if (action.equals("crop")) {
		    				System.out.println("enter an integer for the dimensions of the cropped image (no negatives)");
		    				int dimension = in.nextInt();
		        			Method m = getClass().getDeclaredMethod(action, int.class);
		        			m.invoke(this, dimension);
		    			}
		    			else {
		        			Method m = getClass().getDeclaredMethod(action);
		        			m.invoke(this, new Object[0]);
		    			}
		    			System.out.println("done. enter another action, or type 'done'");
	    			}
	    			catch (NoSuchMethodException e) {
	    				System.out.println("not a valid action, try again");
	    			} catch (IllegalAccessException e) {e.printStackTrace();System.exit(1);} 
	    			catch (IllegalArgumentException e) {e.printStackTrace();System.exit(1);}
	    			catch (InvocationTargetException e) {e.printStackTrace();System.exit(1);}
	    			
	    			action = in.next().toLowerCase();
	    		} 
	        in.close();
	        
	        // turns our 2d array of colors into a new png file
	        create_new_image(new_image);
	        File output_file = new File("Images/" + outputName);
	        ImageIO.write(new_image, "png", output_file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
		
    
    public void create_pixel_array(BufferedImage image) {
        w = image.getWidth();
        h = image.getHeight();
        pixels = new Color[h][];
        for (int i = 0; i < h; i++) {
            pixels[i] = new Color[w];
            for (int j = 0; j < w; j++) {
                pixels[i][j] = new Color(image.getRGB(j,i));
            }
        }
    }

    public void create_new_image(BufferedImage new_image) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
            		new_image.setRGB(j, i, pixels[i][j].getRGB());
            }
        }
    }

    public static void main(String[] args) {
		new PhotoshopFiller();
	}

    public PhotoshopFiller() {
		run();
    }
}
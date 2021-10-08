package introJava;

import java.util.Scanner;

public class whileLoops {
	
	
	// definite finite
	public void numbersBetween(int x, int y) {
		
		System.out.println(Math.min(x, y));
		
		while (x != y) {
			
			if (x <= y) {
				
				x += 1;
				
				System.out.println(x);
				
				
			}
			
			else if (y <= x) {
			
				y += 1;
				
				System.out.println(y);
				
				
				
			}
			
		}
	}
		
	// definite finite 
	public void baseCoefficient(double base, double coefficient) {
		
		int x = 0;
			
		while (x <= 5) {
		
			
			System.out.println((Math.pow(base, x)*coefficient));
			
			x++;
		}
	
	}
		
	// definite finite
	public void squareRoot() {
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("enter an integer: ");
		int num = input.nextInt();
		
		int count = 0;
		
		while (count * count <= num) {
			
			if (count * count == num) {
				System.out.println(count);
				
				return;
			}
			count++;
			
		}
		System.out.println("no square root");	
		
		
	}
	
	// definite finite
	public void largest(int n) {
		
		Scanner input = new Scanner(System.in);
		
		
		int count = 0;
		int largest = 0;
		
		while (count < n) {
			
			System.out.println("enter integer: ");
			
			int num = input.nextInt();
			
			count++;
			
			if (largest < num) {
				largest = num;
			}
		
		}
		System.out.println(largest);

	
	
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		whileLoops runner = new whileLoops();
		
		//runner.numbersBetween(3, 7);
		
		//runner.baseCoefficient(2.0, 3.0);
		
		//runner.squareRoot();
		
		runner.largest(2);
			
		
		}
}
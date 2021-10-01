package introJava;

import java.util.Scanner;

public class userInput {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("enter a number: ");
		int myNum = input.nextInt();
		
		System.out.println("enter full name: ");
		String word = input.nextLine();
		
		if (word.equals("Yumna Syed")) {
			
		}

	}

}
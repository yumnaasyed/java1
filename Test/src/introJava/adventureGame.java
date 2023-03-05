package introJava;

import java.util.*;

public class adventureGame {

	
	public static void startGame(String playerName, int energyLeft, Scanner input) {
		
		System.out.println("Hi " + playerName + "! It is 7AM and you are getting up for school. It is quite chilly outside, do you turn the heat up for 3000 watts? Yes or No");
		
		while (true) {
			String answer = input.nextLine();
			
			if (answer.equalsIgnoreCase("yes")) {
				energyLeft -= 3000;	
				Transport(energyLeft, input, playerName);
				break;
			}
			else if (answer.equalsIgnoreCase("no")) {
				Transport(energyLeft, input, playerName);
				break;
			}
		}
	}
	
	public static void Transport(int energyLeft, Scanner input, String playerName) {
		
		System.out.println("You have " + energyLeft + " watts left for the day.");
		System.out.println("It's time to head out. Do you want to take the bus for 700 watts or a car for 3000 watts?");
		
		while (true) {
			String answer = input.nextLine();
			
			if (answer.equalsIgnoreCase("bus")) {
				energyLeft -= 700;
				classElectronics(energyLeft, input, playerName);
				break;
			}
			else if (answer.equalsIgnoreCase("car")) {
				energyLeft -= 3000;
				carStops(energyLeft, input, playerName);
				break;
			}
		}
	}
	
	public static void carStops(int energyLeft, Scanner input, String playerName) {
		
		System.out.println("You have " + energyLeft + " watts left for the day.");
		System.out.println("Your car has stopped on the side of the road! Do you: A. restart for 3000 watts or take B. public transport for 2000 watts? ");
		
		while (true) {
			String answer = input.nextLine();
			
			if (answer.equalsIgnoreCase("A")) {
				energyLeft -= 3000;
				classElectronics(energyLeft, input, playerName);
				break;
			}
			else if (answer.equalsIgnoreCase("B")) {
				energyLeft -= 2000;
				classElectronics(energyLeft, input, playerName);
				break;
			}
		}
	}
	
	public static void classElectronics(int energyLeft, Scanner input, String playerName) {
		
		System.out.println("You have " + energyLeft + " watts left for the day.");
		System.out.println("You get to class and notice your phone is almost dead and you want it charged for the rest of the day. Do you charge your phone for 3000 watts? Yes or No");
		
		
		while (true) {
			String answer = input.nextLine();
			
			if (answer.equalsIgnoreCase("yes")) {
				energyLeft -= 3000;
				lunch(energyLeft, input, playerName);
				break;
			}
			else if (answer.equalsIgnoreCase("no")) {
				lunch(energyLeft, input, playerName);
				break;
			}
		}
	}
	
	
	public static void lunch(int energyLeft, Scanner input, String playerName) {
		
		System.out.println("You have " + energyLeft + " watts left after the day has ended.");
		System.out.println("you are eating your lunch when you notice someone tried to throw their wrappers away but missed the can. Do you: A. leave your friends and throw away the trash yourself using 500 watts or B. wait for someone else to do it for 2000 watts?");
		
		while (true) {
			String answer = input.nextLine();
			
			if (answer.equalsIgnoreCase("A")) {
				energyLeft -= 500;
				endOfDay(energyLeft, input, playerName);
				break;
			}
			else if (answer.equalsIgnoreCase("B")) {
				energyLeft -= 2000;
				endOfDay(energyLeft, input, playerName);
				break;
			}
		}
	}
	
	public static void endOfDay(int energyLeft, Scanner input, String playerName) {
		
		System.out.println("You have " + energyLeft + " watts left for the day.");
		System.out.print("You made it home. ");
		
		if (energyLeft <= 0) {
			gameOver(energyLeft, input, playerName);
		}
		else {
			System.out.println("And you made it through the day without using more than the average amount of energy! You win! ");
			System.out.println("If you would like to play again and make different decisions, type 'yes'");
			
			while (true) {
				String ans = input.nextLine();
				
				if (ans.equalsIgnoreCase("yes")) {
					energyLeft = 12000;
					startGame(playerName, energyLeft, input);
					break;
				}
			}
		}
		
	}
	
	public static void gameOver(int energyLeft, Scanner input, String playerName) {
		
		System.out.println("But you used up all your energy! :(, If you would like to play again, type 'yes'");
		
		while (true) {
			String ans = input.nextLine();
			
			if (ans.equalsIgnoreCase("yes")) {
				energyLeft = 12000;
				startGame(playerName, energyLeft, input);
				break;
			}
		}
	}
		
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String playerName;
		int energyLeft = 12000; // in watt hours
		
		System.out.print("Welcome to the Energy Awareness Adventure Game! Please enter your character name before we begin: ");
		
		playerName = input.nextLine();
		
		System.out.println("You are starting off with 12000 watts to use today, like an average US citizen. Choose wisely as to not run out!");
		
		startGame(playerName, energyLeft, input);
		

	}
}
package introJava;

import java.util.*;

public class adventureGame {
	
	public static void startGame(String playerName, int energyLeft, Scanner input) {
		
		System.out.println("Hi " + playerName + "! It is 7AM and you are getting up for school. It is quite chilly outside, do you turn the heat up? Yes or No");
		
		String answer = input.nextLine();
		
		if (answer.equalsIgnoreCase("yes")) {
			energyLeft -= 1000;
			Transport(energyLeft, input);
		}
		else if (answer.equalsIgnoreCase("no")) {
			Transport(energyLeft, input);
		}
		else { // fix this
			System.out.println("Please enter that again. yes or no?");
			answer = input.nextLine();
		}
	}
	
	public static void Transport(int energyLeft, Scanner input) {
		
		System.out.println("It's time to head out. Do you want to take the bus or a car?");
		
		String answer = input.nextLine();
		
		if (answer.equalsIgnoreCase("bus")) {
			energyLeft -= 500;
			classElectronics();
		}
		else if (answer.equalsIgnoreCase("car")) {
			energyLeft -= 1500;
			classElectronics();
		}
		else { // fix
			System.out.println("Please enter that again. bus or car?");
			answer = input.nextLine();
		}
	}
	
	public static void classElectronics() {
		
	}
	

	

	
	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String playerName;
		String ans;
		int energyLeft = 12000; // in watt hours
		boolean gameOver = false;
		
		System.out.print("Welcome to the Energy Awareness Adventure Game! Please enter your character name before we begin: ");
		
		playerName = input.nextLine();
		
		System.out.println("You are starting off with 12000 watts to use today, like an average US citizen. Choose wisely as to not run out!");
		
		startGame(playerName, energyLeft, input);
				
		

	}
}
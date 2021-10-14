package introJava;

import java.util.Scanner;

public class forLoops {
	
	private Scanner input = new Scanner(System.in);
	
	//definite finite
	//linear
	//easy
	public void negToPos() {	
		
		System.out.println("enter an integer: ");
		int n = input.nextInt();
		
		for (int i = -n; i <= n; i++ ) {
			System.out.println(i);
		}
		
	}
	
	//definite finite
	//linear
	//easy
	public void hiTimes() {
		
		System.out.println("enter an integer: ");
		int num = input.nextInt();
		
		int count = 0;
		
		while (count < num) {
			System.out.print("hi");
			
			count ++;
		}
			
	}
	
	//indefinite
	//linear
	//easy
	public void chooseNumber() {
		
		int myNumber = 7;
		
		System.out.println("enter an integer: ");
		int num = input.nextInt();
		
		if (num != myNumber) {
			chooseNumber();
		}
		
		else if (num == myNumber) {
			System.out.println("you got it");
		}
		
	}
	
	//indefinite
	//linear
	//medium
	public void simpleGame() {
		
		System.out.println("Do you want to keep playing? ");
		String answer = input.nextLine();

		if (answer.equals("yes")) {
			simpleGame();
		}
	
		else if (answer.equals("no")) {
			System.out.println("Game Over");
		}
		
		return;
		
	}
	
	//definite finite
	//linear
	//medium
	public void factorial() {
		
		System.out.println("enter an integer: ");
		int num = input.nextInt();
		
		int count = 1;
		
		for (int i = 1; i <= num; i++) {
			count *= i;
		}
		
		System.out.println(count);
	}
	
	//definite finite
	//constant
	//hard
	public void lcm(int num1, int num2) {
		
		for (int i = Math.max(num1, num2); i <= num1 * num2; i += Math.max(num1, num2)) {
			
			if (i % Math.min(num1, num2) == 0) {
				System.out.println(i);
				break;
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		
	
		forLoops runner = new forLoops();
		
		runner.negToPos();
		runner.hiTimes();
		runner.simpleGame();
		runner.factorial();
		runner.chooseNumber();
		runner.lcm(6,4);

	}
	
}
package introJava;


import java.util.Scanner;



public class scannerConditionals {
	

	
	public void fourNumbers() {
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("enter 1 number: ");
		int num1 = input.nextInt();
		
		System.out.println("enter 1 number: ");
		int num2 = input.nextInt();
		
		System.out.println("enter 1 number: ");
		int num3 = input.nextInt();
		
		System.out.println("enter 1 number: ");
		int num4 = input.nextInt();
		
		System.out.print(num4);
		System.out.print(num3);
		System.out.print(num2);
		System.out.println(num1);
	}
	
	
	
	public void  mathOperators() {
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("enter a math operation: ");
		String operator = input.next();
		
		System.out.println("enter a number: ");
		int num1 = input.nextInt();
		
		System.out.println("enter a second number: ");
		int num2 = input.nextInt();
		
		if (operator.equals ("add")) {
			System.out.println(num1 + num2);
		}
		
		else if (operator.equals ("subtract")) {
			System.out.println(num1 - num2);
		}
		
		else if (operator.equals ("multiply")) {
			System.out.println(num1 * num2);
		}
		
		else if (operator.equals ("divide")) {
			System.out.println(num1 / num2);
		}
		
		else if (operator.equals ("modulus")) {
			System.out.println(num1 % num2);
		}
		
		else {
			System.out.println(operator + (char)num1 + (char)num2);
		}
		
	}
	
	
	
	public void football() {
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("enter a number of touchdowns: ");
		int touchdowns = input.nextInt();
		
		System.out.println("enter a number of field goals: ");
		int fieldGoals = input.nextInt();
		
		System.out.println("enter a total score: ");
		int score = input.nextInt();
		
		
		int fullTouchdowns = touchdowns / 7;
				
		int fullFeildGoals = fieldGoals / 3;
		
		if () {
			
		}
		
	}
	
	
	
	public void greatestDigit() {
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("enter a 3 digit number: ");
		int num = input.nextInt();
		
		int lastDigit = num % 10;
		
		int secondDigit = (num % 100) / 10;
		
		int firstDigit = (num/1000);
		
		
		if (lastDigit > secondDigit && lastDigit > firstDigit) {
			System.out.println(lastDigit);
		}
		
		else if (secondDigit > lastDigit && secondDigit > firstDigit) {
			System.out.println(secondDigit);
		}
			
		else if (firstDigit > lastDigit && firstDigit > secondDigit) {
			System.out.println(firstDigit);
		}
		
		else {
			System.out.println(lastDigit);
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		scannerConditionals runner = new scannerConditionals();
		
		runner.fourNumbers();
		
		runner.mathOperators();
		
		runner.football();
		
		runner.greatestDigit();

	}
	
}
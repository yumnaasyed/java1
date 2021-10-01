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
	
	
	
	
	public static void main(String[] args) {
		
		scannerConditionals runner = new scannerConditionals();
		
		runner.fourNumbers();
		
		runner.mathOperators();

	}
	
}
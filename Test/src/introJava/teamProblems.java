package introJava;

import java.util.Scanner;

public class teamProblems {
	
	
	public void sum(int n) {
		
		int count = 0;
		
		for (int i = 1; i <= n; i++) {
			count += i;
		}
		
		System.out.print(count);
	}
	
	public void powers(double n, int x) {
		
		for (int i = 1; i <= n; i++) {	
			System.out.println(Math.pow(x, i));
		}
	}
	
	public void average() {
		
		double b = 0;
		double c = 0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("enter an integer:  ");
		int num = input.nextInt();
		
		
		while (num != -1) {
			average();
			b += num;
			num = input.nextInt();
			c++;
		}
		System.out.println(b/c);
	}
	
	public void reverse(int num) {
		
		int newNum = 0;
		
		while (num != 0 ) {
			int digit = num % 10;
			newNum = newNum * 10 + digit;
			num = num/10;
		}
		System.out.println(newNum);
	}
	
	public void decodes(int a) {
		int decoded = 0;
		for (int i = 1; i <= a; i = i *10 ) {
			decoded ++;
		}
		
		for (int i = decoded/2; i >=0; i--) {
			System.out.println((char)((a%(int)(Math.pow(100,  i) / (int)(Math.pow(100,  i -1))))));
		}
	}
	
	
	
	public static void main(String[] args) {
		

		teamProblems runner = new teamProblems();
		
		runner.sum(3);
		runner.powers(3.0, 5);
		runner.average();
		runner.reverse(567);
		runner.decodes(656770);
		


	}
	
}
package introJava;

import java.util.Scanner;

public class startingArrays {
	
	
	public static void display(int[] myArr) {
	
		for (int i = 0; i < myArr.length; i++) {
			
			System.out.print(myArr[i] + " ");
		}
	}
	
	public static void oneToN(int n) {
		
		int[] newArr = new int[n];
		
		for (int i = 1; i <= n; i++) {
			newArr[i-1]= i;
		}
		
		display(newArr);
	}
	
	
	public static void swap(int[] swapArr) {
		
		int first = swapArr[0];
		swapArr[0] = swapArr[swapArr.length - 1];
		swapArr[swapArr.length - 1] = first;
		display(swapArr);
	}
	
	public static void userArray(int x) {
		
		Scanner input = new Scanner(System.in);
		
		int[] newArr = new int[x];
		
		for (int i = 0; i < x; i++) {
			System.out.println("enter a number");
			newArr[i] = input.nextInt();
		}
		display(newArr);
		
	}
	
	public static void reverse(int[] revArr) {
		
		int[] newArr = new int[revArr.length];
		for (int i = 0; i < revArr.length; i++) {
			newArr[i] = revArr[revArr.length - i - 1];
		}
		display(newArr);
	}
	
	
	
	
	public static void main(String[] args) {
		
		int[] myArr = new int[6];
		display(myArr);
		
		oneToN(10);
		
		userArray(7);
		
		int[] swapArr = {5, 6, 7, 8, 9, 10};
		swap(swapArr);
		
		int[] revArr = {6, 5, 4, 3, 2, 1, 0};
		reverse(revArr);

	}
	
}
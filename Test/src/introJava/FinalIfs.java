package introJava;


import java.util.Scanner;



public class FinalIfs {
	
	public void binaryCode(int num5, int num4, int num3, int num2, int num1) {
		
		int num1binary = num1*1;
		
		int num2binary = num2*2;
		
		int num3binary = num3*4;
		
		int num4binary = num4*8;
		
		int num5binary = num5*16;
		
		System.out.println(num1binary + num2binary + num3binary + num4binary + num5binary);
		
	}
	
	
	
	public void switchValues() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("enter a word: ");
		String str1 = input.next();
		
		String word1 = str1;
		
		System.out.println("enter another word: ");
		String str2 = input.next();
		
		str1 = str2;
		str2 = word1;
		
		System.out.println(str1);
		System.out.println(str2);

		
	}
	
	
	
	public void fiveDigits(int num) {
		
		int twoDigits = num/1000;
		
		int ones = num % 10;
		
		int tens = (num % 100) / 10;
		
		int hundreds = (num % 1000) / 100;
		
		int remainderOnes = twoDigits % ones;
		
		int remainderTens = twoDigits % tens;
		
		int remainderHundreds = twoDigits % hundreds;
		
		System.out.println(remainderOnes);
		System.out.println(remainderTens);
		System.out.println(remainderHundreds);
		
	}
	
	
	
	public void letterSum(char letter1, char letter2) {
		
		
		int sum = ((int) letter1 + (int) letter2);
		char theChar = (char) sum;
		
		
		if (sum >= 65 && sum <= 90) {
			System.out.println(theChar);
			
		}
			
		else if (sum >= 97 && sum <= 122){
			System.out.println(theChar);
		}
		
		else if (sum > 122) {
			System.out.print('z');
		}
		
		else if (sum < 65) {
			System.out.println('A');
		}
	
		
	}
	
	
	
	public static void main(String[] args) {
				
		FinalIfs runner = new FinalIfs();
				
				runner.binaryCode(1, 0, 1, 1, 1);
				runner.switchValues();
				runner.fiveDigits(40548);
				runner.letterSum('3', '3');

	}
	
}
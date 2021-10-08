package introJava;

public class booleanPractice3 {
	
	
	public void smallest(int num1, int num2, int num3) {
		
		if (num1 < num2 && num1 < num3) {
			System.out.println(num1);
		}
			
		else if (num2 < num1 && num2 < num3) {
			System.out.println(num2);
		}
		
		else if (num3 < num1 && num3 < num2) {
			System.out.println(num3);
		}
		
		else {
			System.out.println(num1);
		}
		
		
	}
	
	
	public void twoApart(char letter1, char letter2) {
		
		boolean twoLetters = false;
		
		if (letter2 - letter1 == 2 || letter1 - letter2 == 2) {
			
			twoLetters = true;
			
		}
		
		else {
			System.out.println("These letters are not 2 letters apart");
		}
		
		System.out.println(twoLetters);
		

	}
	
	
	public static void main(String[] args) {
		
		booleanPractice3 runner = new booleanPractice3();
			
	//	runner.smallest(3, 3, 7);
		runner.twoApart('A', 'D');


	}
	
}
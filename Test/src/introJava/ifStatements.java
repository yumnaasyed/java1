package introJava;

public class ifStatements {
	
	public void positive(int x) {
		
		if (x > 0) {
			System.out.println("positive");
		}
		
		else if (x < 0) {
			System.out.println("negative");
		}
		
		else {
			System.out.println("zero");
		}
	}
	
	
	public void evenOdd(int x) {
		
		if (x % 2 == 0) {
				System.out.println("even");
		}
		
		else {
				System.out.println("odd");
		}
	}
	
	
	public void upperLower(char x) {
		
		if (x >= 65 && x <= 90) {
			System.out.println("uppercase");
		}
	
		else if (x >= 97 && x <= 122) {
			System.out.println("lowercase");
		}
		
		else {
			System.out.println("neither");
			
		}
	}
	
	public void multiple(int x) {
		
		if (x % 10 == 0) {
			System.out.println("multiple of 10");
		}
		
		else {
			System.out.println("not multiple of 10");
		}
		
	}
	
	public void biggest(double a, double b, double c) {
		
		if (a > b && a > c) {
			System.out.println(a);
		}
		
		else if (b > c && b > a) {
			System.out.println(b);
		}
		
		else {
			System.out.println(c);
		}
	}
	
	
	
	public static void main(String[] args) {

		ifStatements runner = new ifStatements();
		
		runner.positive(-100);
		
		runner.evenOdd(26);
		
		runner.upperLower('A');
		
		runner.multiple(65);
		
		runner.biggest(50, 7, 0.5);
		
	}
	
}
	

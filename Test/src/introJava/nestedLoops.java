package introJava;

public class nestedLoops {
	
	// constant
	public void aToz() {
		
		for (char j = 'A'; j <= 'Z'; j++) {
			System.out.print(j);
			System.out.println();
		
		}
		
	}
	
	// constant
	public void multTable() {
		
		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= 12; j++) {
				System.out.print(i*j + " ");
			}
			System.out.println();
		}
	}
	
	// n^2 run time quadratic
	public void prime(int x) {

		for (int num = 2; num <= x; num++) {
			
			boolean isPrime = false;
			for (int i = 2; i < num; i++) {

					if (num % i == 0) {
						isPrime = true;
						break;
					}
				}
			if (!isPrime) {
				System.out.println(num + " is prime");
				}
			}
	}
	
	
	// constant (n^2)
	public void stars(int n) {
		
		for (int row = 0; row < n; row++) {
			for (int i = 0; i < n; i++) {
				if (row == i) 
					System.out.print("*");	
				else if (row + i == n-1) 
					System.out.print("*");
				else 
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public void pascalsTriangle() {
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		nestedLoops runner = new nestedLoops();
		
		//runner.aToz();
		//runner.multTable();
		runner.prime(10);
		//runner.stars(8);
		//runner.pascalsTriangle();
	}
	
}
package introJava;

public class TuesdayWarmUp {
	
	
	public void digits(int x) {
		
		while (x > 0) {
			System.out.println(x%10);
			x /= 10;
		}
	}
	
	public void box(int x, int y) {
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print("X");
			}
		System.out.println();
		}
	}
	
	public void factors(int n) {
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (i%j == 0) {
					System.out.print(j + "  ");
				}
			}
		System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		
		TuesdayWarmUp runner = new TuesdayWarmUp();
		
		runner.digits(285);
		//runner.box(5, 5);
		//runner.factors(8);

	}
}
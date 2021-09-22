package introJava;

public class worksheetProblems {
	
	public void numToChar(int x) {
		
		System.out.println((char)x);
	
	}
	
	public void lastDigit(int x) {
		
		System.out.println(x % 10);
	
	}
	
	public void average(int x, int y) {
		
		System.out.println((double)(x + y)/2);

	}
	
	public static void main(String[] args)  {
		
		worksheetProblems runner = new worksheetProblems();
		
		runner.numToChar(100);
		
		runner.lastDigit(25);
		
		runner.average(100, 10);
		
	}

}
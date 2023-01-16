package introJava;
import java.util.*;
import java.util.HashMap;

public class FibonacciSequenceHashMap{
	
	private static HashMap<Integer, Integer> sequence = new HashMap<>();
	
	
	public static int fibonacci(int n) {
		
		
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		
		if (sequence.containsKey(n)) {
			return sequence.get(n);
		}
		
		int value = fibonacci(n-1) + fibonacci(n-2);
		sequence.put(n, value);
		
		return value;
	}
	
	public static void main (String[]args) {
		
		int n = 4;
		
		System.out.println("The " + n + "th number in the fibonacci sequence is " + fibonacci(n));
		
	}

}
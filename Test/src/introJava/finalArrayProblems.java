package introJava;

public class finalArrayProblems {
	
	
	public static void indexSum(double[] arr) {
		
		double sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum += (i*arr[i]);
		}
		System.out.print(sum);
	}
	
	
	public static void adjacentSum(int[] arr, int num) {
		
		boolean sum = false;
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] + arr[i-1] == num) {
				sum = true;
			}
		}
		if (sum) {
			System.out.print("yes");
		}
		else {
			System.out.print("no");
		}
	}
	
	
	public static void addString(char[] arr) {
		
		String word = "";
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 97 && arr[i] <= 122) {
				word += arr[i];
			}
		}
		System.out.println(word);
	}
	
	// 
	public static void oftenChar(char[] arr) {
		
		int max = 0;
		char letter = 'y';
		for (int i = 0; i < arr.length; i++) {
			int matches = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					matches += 1;
				}
			}
			if (matches > max) {
				max = matches;
				letter = arr[i];
			}
		}
		System.out.println(letter);
	}
	
	
	public static void main(String[] args) {
		
		//indexSum(new double[] {5.8, 3.1, 2.5});
		
		//adjacentSum(new int[] {1, 5, 2, 4, 3}, 14);
		
		//addString(new char[] {'h', 'i', '!', 'H', 'e', 'l', 'L', 'o', '?', 'y'});
		
		oftenChar(new char[] {'h', 'k', 'h', 'u', 'b', 'e', 'k', 'u', 'u'});
		
		
	}
	
}
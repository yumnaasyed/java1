package introJava;

import java.util.Arrays;

public class warmingUpBreak {
	
	public static boolean alphabetic(String n) {
		
		for (int i = 1; i < n.length(); i++) {
			if (n.charAt(i) < n.charAt(i-1)) {
				return false;
			}
		}
		return true;
	}
	
	public static String highestGrade(String[] names, int[] grades) {
		
		int maxI = 0;
		for (int i = 0; i < names.length; i++) {
			if (grades[maxI] > grades[i]) {
				maxI = i;
			}
		}
		return names[maxI];
	}
	
	public static int[] perfSquare(int n) {
		
		int[] squares = new int[n];
		
		for (int i = 0, j = 1; i < squares.length; i++, j+=2) {
			squares[i] = j*j;
		}
		return squares;
	}
	
	public static String every3(String str) {
		
		String newStr = "";
		
		for (int i = 0; i < str.length()-3; i+=3) {
			if (i % 2 == 0) {
				newStr += str.substring(i, i+3);
			}
		}
		if (str.length() % 6 < 3) {
			newStr += str.substring(str.length() - str.length() % 6);
		}		
		return newStr;
	}
	
	
	
	public static void main(String[] args) {
		
		boolean n = alphabetic("behlo");
		
		String ans = highestGrade(new String[] {"sally", "jim", "greg"}, new int[] {95, 68, 58});
		
		int[] square = perfSquare(5);
		
		String three = every3("abcdefghijklm");
		
		
		System.out.println(n);
		
		System.out.println(ans);
		
		System.out.println(Arrays.toString(square));
		
		System.out.println(three);
		
		

	}
	
}
//Yumna Syed

package introJava;

import java.util.Arrays;

public class nestedLoopArrays {
	
	// easy
	public static String[] negPos(int[] arr) {
		
		String[] newArr = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] < 0) {
				newArr[i] = "neg";
			}
			else {
				newArr[i] = "pos";
			}
		}
		return newArr;
	}
	
	// easy
	public static int[] sumArrays(int[] arr, int[] arr2) {
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] += arr2[i];
		}
		return arr;
	}
	
	// hard
	public static void commonNum(int[] arr1, int[] arr2) {
		
		for (int i = 0; i < arr1.length; i++) {
			
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					System.out.print(arr1[i] + " ");
				}
			}
		}
	}
	
	// hard
	public static void uniqueNum(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			boolean found = false;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					found = true;
				}
			}
			if (found == false) {
				System.out.print(arr[i]);
			}
		}
	}
	
	// hard
	public static int[] intToArr(int n) {
		
		int length = String.valueOf(n).length();
		int[] arr = new int[length];
		
		for (int i = arr.length-1; i >= 0; i--) {
			arr[i] = n%10;
			n /= 10;
		}
		return arr;
	}
	
	// hard
	public static String[] combine(char[] arr, char[] arr2) {
		
		String[] newArr = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			String word = arr[i] + "";
			for (int j = 0; j < arr2.length; j++) {
				word += arr2[j];
			}
			newArr[i] = word;
		}
		return newArr;
	}
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(negPos(new int[] {-5, 7, -10, 6, -4, -9})));
			
		System.out.println(Arrays.toString(sumArrays(new int[] {6, 5, 2, 4}, new int[] {4, 5, 8, 6})));
		
		commonNum(new int[] {5, 3, 7, 12}, new int[] {5, 3, 6, 12});
		
		uniqueNum(new int[] {5, 2, 2, 7, 5, 8, 9});
		
		System.out.println(Arrays.toString(intToArr(156385)));
		
		System.out.println(Arrays.toString(combine(new char[] {'c', 'l', 'm', 't'}, new char[] {'o', 'a', 'd'})));

	}
	
}
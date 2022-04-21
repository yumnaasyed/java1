package introJava;

import java.util.Arrays;

public class importantArrays {
	
	
	public static int max(int[] array) {
		
		int maxI = 0;
		
		for (int i = 1; i < array.length; i++ ) {
			if (array[i] > array[maxI] ) {
				maxI = i;
			}
		}
		return maxI;
	}
	
	
	public static String[] reverse(String[] array) {
		
		for (int i = 0; i < array.length/2; i++) {
			String temp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = temp;
		}
		return array;
	}
	
	
	public static double average(int[] array) {
		
		double sum = 0;
		
		for (int num : array) {
			sum += num;
		}
		return sum/array.length;
	}
	
	
	public static char[] merge(char[] arr1, char[] arr2) {
		
		char[] newArr = new char[arr1.length + arr2.length];
		
		for (int i = 0; i < arr1.length; i++) {
			newArr[i] = arr1[i];
		}
		for (int i = 0; i < arr2.length; i++) {
			newArr[i + arr1.length] = arr2[i];
		}
		return newArr;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		//int[] array = {6, 5, 4, 3, 2, 1, 0};
		
		
		//char[] ans = merge(new char[] {'e', 'h'}, new char[] {'j', 'l', 'u', 'y'});
		
		//String[] arr = reverse(new String[] {"hi", "hello", "bye"});
		
		//System.out.println(Arrays.toString(arr));
		
		
		
		

	}
	
}
package introJava;

import java.util.Arrays;

public class warmingBackUpArrays {

	
	//easy
	public static void doubles(int[] arr) {
		
		int[] newArr = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = (arr[i])*2;
		}
		System.out.println(Arrays.toString(newArr));
	}
	
	//medium
	public static void fibonacci(int n) {
		
		int[] arr = new int[n];
		
		arr[0] = 0;
		
		if (n > 1) {
		
			arr[1] = 1;
			
			for (int i = 2; i < arr.length; i++) {
				arr[i] = arr[i-1] + arr[i-2];
			}
		
		}
		System.out.println(Arrays.toString(arr));
	}
	
	//easy
	public static void average(double[] arr) {
		
		double total = 0;
		
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		System.out.println((double)(total/arr.length));	
	}
	
	//hard
	public static void risingAvg(int[] arr) {
		
		double[] avg = new double[arr.length];
		double sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			avg[i] = sum/(i+1);
		}
		System.out.println(Arrays.toString(avg));
	}
	
	//medium
	public static void trim(int[] arr) {
		
		int[] newArr = new int[arr.length-2];
		int maxI = arr[0];
		int minI = arr[0];
		
		for (int i = 1; i < arr.length; i++ ) {
			if (arr[i] > maxI) {
				maxI = arr[i];
			}
			if (arr[i] < minI) {
				minI = arr[i];
			}
		}
		for (int i = 0, j = 0; i < arr.length; i++) {
			
			if (arr[i] != maxI && arr[i] != minI) {
				newArr[j] = arr[i];
				j++;
			}
		}
		System.out.println(Arrays.toString(newArr));
	}
	
	//hard
	public static void dotProduct(int[] arr1, int[] arr2) {
		
		int product = 0;
		int[] newArr = new int[arr1.length];
		
		for (int i = 0; i < arr1.length; i++) {
			newArr[i] = arr1[i] * arr2[i];
			product += newArr[i];
		}
		System.out.println(product);
	}
	
	//easy
	public static void eachWord(String[] words) {
		
		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}
	}
	
	//easy
	public static void oneToN(int n) {
		int[] newArr = new int[n];
		
		for (int i = 1; i < n; i++) {
			newArr[i] = i;
		}
		System.out.println(Arrays.toString(newArr));
	}
	
	
	
	
	public static void main(String[] args) {
		
		//doubles(new int[] {5, 2, 7, 8, 9});
		
		//fibonacci(10);
		
		//average(new double[] {6, 7, 8});
		
		//risingAvg(new int[] {4, 6, 2, 12});
		
		//trim(new int[] {18, 7, 2, 8, 15});
		
		//dotProduct(new int[] {5, 3, 1}, new int[] {8, 4, 7});
		
		//eachWord(new String[] {"hello", "hi", "hey"});
		
		//oneToN(10);

	}
	
}
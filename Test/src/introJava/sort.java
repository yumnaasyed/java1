package introJava;

import java.util.Arrays;

public class sort {
	
	public static void selectSort(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			int min = Integer.MAX_VALUE;
			int minInd = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					minInd = j;
				}
			}
			int temp = arr[i];
			arr[i] = min;
			arr[minInd] = temp;
		}
		System.out.print(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		
		selectSort(new int[] {5, 1, 8, 3, 2});

	}
	
}
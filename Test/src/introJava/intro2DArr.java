package introJava;

import java.util.Arrays;

public class intro2DArr {
	
	// 6
	// 1
	// out of bounds
	// 3
	// k
	// out of bounds
	// 105
	// k
	// {7, 6}
	
	public static void integer(int n) {
		
		int[][] arr = new int [n][n];
		
		for (int i = 0; i < arr.length; i ++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = i*n + j;
			}
		}
		
		for (int[] row: arr)
			System.out.println(Arrays.toString(row));
	}
	
	
	public static void columnsRows(String[][] arr) {
		
		System.out.println("columns:" + arr[0].length);
		System.out.println("rows:" + arr.length);
	}
	
	
	public static void sixInt(int num1, int num2, int num3, int num4, int num5, int num6) {
		
		int[][] newArr = {{num1}, {num2, num3}, {num4, num5, num6}};
		
		for (int[] row: newArr)	
			System.out.println(Arrays.toString(row));
	}
	
	
	
	public static void main(String[] args) {
		
		integer(6);
		
		columnsRows(new String[4][3]);
		
		sixInt(1, 2, 3, 4, 5, 6);
		
			
	}
	
}
package introJava;

import java.util.Arrays;

public class more2Darr {
	
	public static void display(int[][] arr) {
		for (int[] row: arr) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	public static int[][] mByN(int m, int n) {
		
		int[][] newArr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newArr[i][j] = i*m+j+1;
			}
		}
		return newArr;
	}
	
	
	public static double max (double[][] arr) {
		
		double max = arr[0][0];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (max < arr[i][j]) {
					max = arr[i][j];
				}
			}
		}
		return max;
	}
	
	
	public static int average(int[][] arr) {
		
		int total = 0;
		int indexs = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
				indexs++;
			}
		}
		return total/indexs;
	}
	
	
	public static int[] oneArr(int[][] arr) {
		
		int[] sum = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sum[i] += arr[i][j];
			}
		}
		return sum;
		
	}
	
	
	public static boolean matrix(int[][] arr) {
		
		int sum = 0;
		int sum2 = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i][i];
		}
		
		for (int x = 0, y = arr.length-1; x < arr.length; x++, y--) {
			sum2 += arr[y][x];
		}
		if (sum != sum2) {
			return false;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (sumRow(i, arr) != sum) {
				return false;
			}
		}
		
		for (int i = 0; i < arr[0].length; i++) {
			if (sumColumn(i, arr) != sum) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int sumRow(int rowNum, int[][] arr) {
		
		int rowSum = 0;
		for (int i = 0; i < arr[rowNum].length; i++) {
			rowSum += arr[rowNum][i];
		}
		return rowSum;
	}
	
	public static int sumColumn(int columnNum, int[][] arr) {
		
		int columnSum = 0;
		for (int i = 0; i < arr.length; i++) {
			columnSum += arr[i][columnNum];
		}
		return columnSum;
	}
	
	
	
	
	public static void main(String[] args) {
		
		display(mByN(6, 5));
		
		//System.out.print(max(new double[][] {{5.6, 2.3}, {2.8, 4.2, 5.8}, {7.6, 6.7, 5.5}}));

		//System.out.print(average(new int[][] {{5, 4, 3}, {4, 3, 5, 2}, {5, 3, 6}}));
		
		//System.out.print(Arrays.toString(oneArr(new int[][] {{3, 5, 2}, {8, 3}, {9, 0, 1, 4}})));
		
		System.out.print(matrix(new int[][] {{2, 7, 6}, 
											{9, 5, 1}, 
											{4, 3, 9}}));
		
		
	}
	
}
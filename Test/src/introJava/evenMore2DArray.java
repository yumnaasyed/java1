package introJava;

import java.util.Arrays;

public class evenMore2DArray {
	
	public static void display(int[][] arr) {
		for (int[] row: arr) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	//easy
	public static void buildString(char[][] arr) {
		
		String word = "";
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				word += arr[i][j];
			}
		}
		System.out.print(word);
	}
	
	//easy
	public static int[][] squareMatrix(int n) {
		
		int[][] arr = new int[n][n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i][i] = n;
		}
		for (int i = 0, j = arr.length-1; i < arr.length; j--, i++) {
			arr[i][j] = n;
		}
		return arr;
	}
	
	//medium
	public static int[][] zeros(int[][] arr) {
		
		int[][] newArr = new int[arr.length][arr[0].length*2];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0, x = 0; j < arr[i].length*2; j+=2, x ++) {
				newArr[i][j] = arr[i][x];
			}
		}
		return newArr;
	}
	
	//medium
	public static int[][] reverse(int[][] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length/2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][arr[i].length-j-1];
				arr[i][arr[i].length-j-1] = temp;
			}
		}
		return arr;
	}
	
	//hard
	public static void columnSum (double[][] arr) {
		
		double[] newArr = new double[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			double sum = 0;
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[j][i];
			}
			newArr[i] = sum;
		}
		System.out.print(Arrays.toString(newArr));
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		//buildString(new char[][] {{'h','e','l'}, {'l', 'o'}});
		
		//display(squareMatrix(5));
		
		//display(zeros(new int[][] {{1, 2, 3}, {4, 5, 6}}));
		
		//display(reverse(new int[][] {{1, 2, 3}, {4, 5, 6}}));
		
		columnSum(new double[][] {{7.6, 4.5, 8.6}, 
								{6.0, 3.2, 2.8}, 
								{2.1, 1.7, 9.0}});
		
		
		
		
		
		

	}
	
}
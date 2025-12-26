package com.generic;

/**
 * This class rotates a two-dimensional array (or a matrix) by 90 degrees
 * clockwise.
 *
 */
public class RotateImageArray {

	public static void main(String[] args) {
		
		int[][] grid0 = {
				{ 1,  2,  3,  4,  5},
				{ 6,  7,  8,  9,  10},
				{ 11, 12, 13, 14, 15},
		};
		
		print2DArray(grid0);
		
		int[][] rotated = getRotatedImageArray(grid0);
		
		print2DArray(rotated);
	}

	private static int[][] getRotatedImageArray(int[][] grid) {
		int r = grid.length;
		int c = grid[0].length;
		
		int[][] na = new int[c][r];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				na[j][r-i-1] = grid[i][j];
			}
		}
		
		return na;
	}
	
	private static void print2DArray(int[][] ar) {
		int r = ar.length;
		int c = ar[0].length;

		System.out.print("\n");
		for (int i = 0; i < r; i++) {
			System.out.print("\t["); // println -- first prints and then takes cursor to new line.
			for (int j = 0; j < c; j++) {
				System.out.format(" %02d", ar[i][j]);
			}
			System.out.print(" ]\n");
		} 
		
	}

}

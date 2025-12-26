package com.tests.examples;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RotateImage {

	public static void main(String[] args) {

		java.util.Random rand = new java.util.Random();
		
		int size = 4;
		int[][] img = new int[size][size];
		int z = 0;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				//img[i][j] = rand.nextInt(64);
				img[i][j] = ++z;
			}
		}
		
//		print2DArray(img);
//		//var1.forEach(System.out::println);
//		//IntStream m = Arrays.stream(img).flatMapToInt(x -> Arrays.stream(x));
//		int [][] res = rotate_img(img, size);
//		System.out.println("\nRotated image");
//		print2DArray(res);
		
//		int[][] res = rotate_clockwise(img, 4);
//		print2DArray(res);

		
		int size1 = 4;
		int[][] anarr = new int[size1][size1];
		int z1 = 20;
		
		for (int i = 0; i < size1; i++) {
			for (int j = 0; j < size1; j++) {
				//img[i][j] = rand.nextInt(64);
				anarr[i][j] = ++z1;
			}
		}

		print2DArray(anarr);
		
		int[][] res2 = rotate_counterclockwise(anarr, 4);
		print2DArray(res2);
	}

	private static void print2DArray(int[][] img) {
		Stream<int[]> var1 = Arrays.stream(img);
		var1.forEach(arr -> {
			int[] a = (int[]) arr;
			IntStream var2 = Arrays.stream(a);
			var2.forEach(e -> System.out.print(e + " "));
			System.out.println();
		});
	}

	private static int[][] rotate_img(int[][] img, int size) {
		int [][] rotated = new int[size][size];
		
		for (int k = 0; k < size; k++) {
			for (int l = 0; l < size; l++) {
				rotated[k][l] = img[size-l-1][k];
			}
		}
		
		return rotated;
	}
	
	private static int[][] rotate_clockwise(int[][] img, int size) {
		System.out.println("\n rotate_clockwise");
		// first transpose the matrix
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				int temp = img[i][j];
				img[i][j] = img[j][i];
				img[j][i] = temp;
			}
		}
		System.out.println("rotate_clockwise -- after transpose..");
		print2DArray(img);
		
		// for clockwise rotation reverse each row
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size/2; j++) {
				int temp = img[i][j];
				img[i][j] = img[i][size-j-1];
				img[i][size-j-1] = temp;
			}
		}
		
		return img;
	}
	
	private static int[][] rotate_counterclockwise(int[][] img, int size) {
		System.out.println("\nrotate_counterclockwise");
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				int temp = img[i][j];
				img[i][j] = img[j][i];
				img[j][i] = temp;
			}
		}
//		System.out.println("rotate_counterclockwise -- after transpose..");
//		print2DArray(img);
		
		System.out.println("\nAnswer");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size/2; j++) {
				int temp = img[j][i];
				img[j][i] = img[size-j-1][i];
				img[size-j-1][i] = temp;
			}
		}
		
		return img;
	}
	
	
	

}

/*
 * Spiral Matrix II - AC Rate: 341/1052 - My Submissions
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */

package SpiralMatrix2;

// AC on 3rd try :(
public class Solution {
	private int[] Xs = new int[]{0, 1, 0, -1}, Ys = new int[]{1, 0, -1, 0};
	
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int cur = 1;
		for(int i = 0; i < (n+1) / 2; i++) { // bug: should be n+1
			cur = fillMatrix(matrix, i, n - 1 - i, cur);
		}
		return matrix;
	}
	
	public int fillMatrix(int[][] matrix, int min, int max, int cur) {
		if(min == max) {
			matrix[min][min] = cur++;
			return cur;
		}
		int i = min, j = min;
		matrix[i][j] = cur++;
		for(int k = 0; k < 4; ) {
			i += Xs[k];
			j += Ys[k];
			if(i == min && j == min) break; // need to check before assign
			matrix[i][j] = cur++;
			if((i == min || i == max) && (j == min || j == max)) k++;
		}
		return cur;
	}
}

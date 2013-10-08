/*
 * Maximal Rectangle - Apr 24 '12 - 3792 / 13475
Given a 2D binary matrix filled with 0's and 1's, 
find the largest rectangle containing all ones and return its area.
 */

package MaximalRectangle;

import java.util.Stack;

// AC after several tries, due to LC problems
// For O(n^2) solution, AC on 1st try :)
// For O(n^3) solution, will get TLE
public class Solution {
	public int maximalRectangleON2(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		
		int m = matrix.length, n = matrix[0].length;
		int[][] ones = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			ones[i][n-1] = (matrix[i][n-1] == '1') ? 1 : 0;
			for(int j = n-2; j >= 0; j--) {
				if(matrix[i][j] == '0') ones[i][j] = 0;
				else ones[i][j] = ones[i][j+1] + 1;
			}
		}
		
		int max = 0;
		for(int j = 0; j < n; j++) {
			int temp = maxRectangle(j, ones);
			if(temp > max) max = temp;
		}
		return max;
	}
	
	public int maxRectangle(int j, int[][] ones) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0, i = 0;
		
		while(i <= ones.length) {
			if(stack.isEmpty() || (i < ones.length && ones[i][j] >= ones[stack.peek()][j]))
				stack.add(i++);
			else {
				int temp = ones[stack.pop()][j];
				temp *= (stack.isEmpty() ? i : (i - 1 - stack.peek()));
				if(temp > max) max = temp;
			}
		}
		
		return max;
	}
	
	public int maximalRectangleON3(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		
		int m = matrix.length, n = matrix[0].length;
		int[][] ones = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			ones[i][n-1] = (matrix[i][n-1] == '1') ? 1 : 0;
			for(int j = n-2; j >= 0; j--) {
				if(matrix[i][j] == '0') ones[i][j] = 0;
				else ones[i][j] = ones[i][j+1] + 1;
			}
		}
		
		int res = 0;
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++){
				int cur = i, minWidth = ones[i][j], max = ones[i][j];
				while(cur < m && ones[i][cur] > 0) {
					if(ones[i][cur] < minWidth) minWidth = ones[i][cur];
					if((cur - i + 1) * minWidth > max) max = (cur - i + 1) * minWidth;
				}
				if(max > res) res = max;
			}
		return res;
	}
}

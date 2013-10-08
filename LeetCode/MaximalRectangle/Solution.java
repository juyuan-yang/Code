/*
 * Maximal Rectangle - Apr 24 '12 - 3792 / 13475
Given a 2D binary matrix filled with 0's and 1's, 
find the largest rectangle containing all ones and return its area.
 */

package MaximalRectangle;

public class Solution {
	public int maximalRectangle(char[][] matrix) {
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

/*
 * Minimum Path Sum - AC Rate: 382/1188 - My Submissions
Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */

package MinimumPathSum;

// AC on 2nd try... It's minimum...
public class Solution {
	public int minPathSum(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		
		int m = grid.length, n = grid[0].length;
		int[][] res = new int[m][n];
		
		for(int i = 1; i < m; i++) res[i][0] = res[i-1][0] + grid[i][0];
		for(int j = 1; j < n; j++) res[0][j] = res[0][j-1] + grid[0][j];
		
		for(int i = 1; i < m; i++)
			for(int j = 1; j < n; j++){
				res[i][j] = grid[i][j] + 
						((res[i-1][j] < res[i][j-1]) ? res[i-1][j] : res[i][j-1]);
			}
		
		return res[m-1][n-1];
	}
}

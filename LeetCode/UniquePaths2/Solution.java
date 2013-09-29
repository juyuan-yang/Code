/*
 * Unique Paths II AC Rate: 292/998 My Submissions
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
 */

package UniquePaths2;

// AC on 1st try :)
public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
			return 0;
		
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] res = new int[m][n];
		res[0][0] = (obstacleGrid[0][0] == 1) ? 0 : 1;
				
		for(int i = 1; i < m; i++) res[i][0] = (obstacleGrid[i][0] == 1) ? 0 : res[i-1][0];
		for(int j = 1; j < n; j++) res[0][j] = (obstacleGrid[0][j] == 1) ? 0 : res[0][j-1];
		
		for(int i = 1; i < m; i++)
			for(int j = 1; j < n; j++){
				res[i][j] = (obstacleGrid[i][j] == 1) ? 0 : res[i-1][j] + res[i][j-1];
			}
		
		return res[m-1][n-1];
	}
}

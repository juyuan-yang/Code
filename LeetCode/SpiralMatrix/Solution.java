/*
 * Spiral Matrix - AC Rate: 541/2781 - My Submissions
Given a matrix of m x n elements (m rows, n columns), 
return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 */

package SpiralMatrix;

import java.util.ArrayList;

// AC on 3rd try :( many silly mistakes...
public class Solution {
	private int[] Xs = new int[]{0, 1, 0, -1}, Ys = new int[]{1, 0, -1, 0};
	
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
		int m = matrix.length, n = matrix[0].length, i = 0, j = 0, cur = 0;
		boolean[][] visited = new boolean[m][n];
		
		for(int k = 0; k < m*n; ) {
			if(!visited[i][j]) {
				visited[i][j] = true;
				res.add(matrix[i][j]);
				k++;
			}
			if(i + Xs[cur] >= 0 && i + Xs[cur] < m && j + Ys[cur] >= 0
					&& j + Ys[cur] < n && !visited[i + Xs[cur]][j + Ys[cur]]) {
				i += Xs[cur];
				j += Ys[cur];
			} else {
				cur++;
				if(cur == 4) cur = 0;
			}
		}
		return res;
	}
}

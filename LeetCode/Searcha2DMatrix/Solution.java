/*
 * Search a 2D Matrix - AC Rate: 353/1114 - My Submissions
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 */

package Searcha2DMatrix;

// AC on 3rd try :(
public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		// Bug, forget to have this check
		if(target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1]) return false;
		int start = 0, end = matrix.length - 1, mid, index;
		
		while(start <= end) { // bug, forgot = operation
			mid = (start + end) / 2;
			if(matrix[mid][0] == target) return true;
			else if(matrix[mid][0] < target) start = mid + 1;
			else end = mid - 1;
		}
		
		index = end;
		start = 0;
		end = matrix[0].length - 1;
		
		while(start <= end) {
			mid = (start + end) / 2;
			if(matrix[index][mid] == target) return true;
			else if(matrix[index][mid] > target) end = mid - 1;
			else start = mid + 1;
		}
		return false;
	}
}

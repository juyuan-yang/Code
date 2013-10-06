/*
 * Sort Colors - AC Rate: 305/1097 - My Submissions
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 */

package SortColors;

public class Solution {
	// AC on 2nd try :( Anyway, should be easy
	public void sortColors(int[] A) {
		if(A == null || A.length == 0) return;
		int leftOne = -1, cur = 0, right = A.length - 1;
		
		while(cur <= right) {
			if(A[cur] == 0) {
				if(leftOne != -1) {
					A[leftOne++] = 0;
					A[cur] = 1;
				}
				cur++;
			} else if(A[cur] == 1) {
				if(leftOne == -1) leftOne = cur;
				cur++;
			} else {
				A[cur] = A[right];
				A[right--] = 2;
			}
		}
	}
}

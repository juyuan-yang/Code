/*
 * First Missing Positive - AC Rate: 765/3626 My Submissions
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */

package FirstMissingPositive;

// AC after several tries... Forgot the break statement... also LC seems to have some problems.
public class Solution {
	public int firstMissingPositive(int[] A) {
		if(A == null || A.length == 0) return 1;
		for(int i = 0; i < A.length; i++) {
			while(A[i] != i + 1) {
				if(A[i] > 0 && A[i] <= A.length && A[A[i]-1] != A[i]) {
					int temp = A[i];
					A[i] = A[A[i] - 1];
					A[temp-1] = temp;
				} else break;
			}
		}
		for(int i = 0; i < A.length; i++) {
			if(A[i] != i + 1) return i+1;
		}
		return A.length+1;
	}
}

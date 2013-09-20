/*
 * Remove Duplicates from Sorted Array II - AC Rate: 102/299 - My Submissions
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
 */

package RemoveDuplicatesfromSortedArray2;

// AC on 1st try :)
public class Solution {
	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0) return 0;
		int res = 1, base = A[0];
		boolean second = false;
		
		for(int cur = 1; cur < A.length; cur++) {
			if(A[cur] == base) {
				if(!second) second = true;
				else continue;
			} else {
				second = false;
				base = A[cur];
			}
			A[res++] = A[cur];
		}
		return res;
	}
}

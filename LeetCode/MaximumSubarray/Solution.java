/*
 * Maximum Subarray - AC Rate: 1088/3112 - My Submissions
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

package MaximumSubarray;

public class Solution {
	// AC on 1st try :) Divide and conquer?
    public int maxSubArray(int[] A) {
        if(A == null || A.length == 0) return 0;
        int max = A[0], sofar = (A[0] > 0) ? A[0] : 0;
        
        for(int i = 1; i < A.length; i++) {
            sofar += A[i];
            if(sofar > max) max = sofar;
            if(sofar < 0) sofar = 0;
        }
        
        return max;
    }
}

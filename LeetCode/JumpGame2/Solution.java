/*
 * Jump Game II - AC Rate: 687/2946 - My Submissions
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. 
(Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */

package JumpGame2;

// AC on 2nd try :( just one condition, max >= length - 1!
public class Solution {
    public int jump(int[] A) {
        if(A == null || A.length < 2) return 0;
        int start = 0, end = 0, step = 0;
        
        while(true) {
            step++;
            int max = start + A[start];
            for(int i = start+1; i <= end; i++) {
                if(i + A[i] > max) max = i + A[i];
            }
            if(max >= A.length - 1) return step;
            if(max <= end) return -1;
            start = end+1;
            end = max;
        }
    }
}

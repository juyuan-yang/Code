/*
 * 3Sum Closest - AC Rate: 1119/3990 My Submissions
Given an array S of n integers, find three integers in S such that 
the sum is closest to a given number, target. Return the sum of the three integers. 
You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

package ThreeSumClosest;

import java.util.Arrays;

// AC on 2nd try :( a typo...
public class Solution {
	public int threeSumClosest(int[] num, int target) {
        if(num == null || num.length < 3) return 0;
        Arrays.sort(num);
        int res = num[0] + num[1] + num[2];
        for(int i = 0; i <= num.length - 3; i++) {
        	int j = i + 1, k = num.length - 1;
        	while(j < k) {
        		int sum = num[i] + num[j] + num[k];
        		if(Math.abs(sum - target) < Math.abs(res - target)) res = sum;
        		if(sum == target) return target;
        		else if(sum > target) k--;
        		else j++;
        	}
        }
        return res;
	}
}

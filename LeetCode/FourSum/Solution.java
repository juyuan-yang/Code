/*
 * 4 Sum - AC Rate: 875/3943 My Submissions
Given an array S of n integers, are there elements a, b, c, 
and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 */

package FourSum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	// AC on 3rd try... Some typos... And, j need to start from length-1, and decrease, rather than increase
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 4) return res;
        Arrays.sort(num);
        for(int i = 0; i <= num.length - 4; i++) {
            for(int j = num.length - 1; j >= i + 3; j--) {
                int s = i + 1, t = j - 1;
                while(s < t) {
                    int total = num[i] + num[s] + num[t] + num[j];
                    if(total == target) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[s]);
                        list.add(num[t]);
                        list.add(num[j]);
                        res.add(list);
                        
                        while(s < t && num[s] == num[s+1]) s++;
                        s++;
                        while(s < t && num[t] == num[t-1]) t--;
                        t--;
                    } else if(total < target) {
                        while(s < t && num[s] == num[s+1]) s++;
                        s++;
                    } else {
                        while(s < t && num[t] == num[t-1]) t--;
                        t--;
                    }
                }
                
                while(j-1 > i && num[j] == num[j-1]) j--;
            }
            while(i+1 <= num.length - 4 && num[i] == num[i+1]) i++;
        }
        return res;
    }
}

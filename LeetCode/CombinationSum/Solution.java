/*
 * Combination Sum AC Rate: 654/2575 My Submissions
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, �� , ak) must be in non-descending order. (ie, a1 �� a2 �� �� �� ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
 */

package CombinationSum;

import java.util.ArrayList;

// AC on 2nd try :( but it's just silly mistake..
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(candidates == null || candidates.length == 0) return res;
        quicksort(candidates, 0, candidates.length-1);
        tryNext(res, candidates, 0, target, new int[target / candidates[0] + 1], 0, 0);
        return res;
    }
    
    public void tryNext(ArrayList<ArrayList<Integer>> res, int[] num, int level, int target, int[] has, int pos, int total) {
        if(total > target) return;
        else if(total == target) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < pos; i++) list.add(has[i]);
            res.add(list);
            return;
        } else {
            if(level == num.length) return;
            tryNext(res, num, level+1, target, has, pos, total);
            while(pos < has.length && total < target) {
                has[pos++] = num[level];
                total += num[level];
                tryNext(res, num, level+1, target, has, pos, total);
            }
        }
    }
    
    public void quicksort(int[] num, int s, int t) {
        int i = s, j = t;
        int temp = num[s];
        
        while(i < j) {
            while(i < j && temp < num[j]) j--;
            if(i < j) {
                num[i] = num[j];
                i++;
            }
            while(i < j && temp > num[i]) i++;
            if(i < j) {
                num[j] = num[i];
                j--;
            }
        }
        num[i] = temp;
        
        if(s < i-1) quicksort(num, s, i-1);
        if(i+1 < t) quicksort(num, i+1, t);
    }
}

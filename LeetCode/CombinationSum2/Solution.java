/*
 * Combination Sum II AC Rate: 532/2190 My Submissions
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, �� , ak) must be in non-descending order. (ie, a1 �� a2 �� �� �� ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
 */

package CombinationSum2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// Ac on 2nd try :( need to take care of duplicates, like {1} with {1}
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return res;
        quicksort(num, 0, num.length-1);
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        tryNext(set, num, 0, target, new int[num.length], 0, 0);
        res.addAll(set);
        return res;
    }
    
    public void tryNext(Set<ArrayList<Integer>> set, int[] num, int level, int target, int[] has, int pos, int total) {
        if(total > target) return;
        else if(total == target) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < pos; i++) list.add(has[i]);
            set.add(list);
            return;
        } else {
            if(level == num.length) return;
            tryNext(set, num, level+1, target, has, pos, total);
            has[pos++] = num[level];
            total += num[level];
            tryNext(set, num, level+1, target, has, pos, total);
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

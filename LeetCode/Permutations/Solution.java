/*
 * Permutations - AC Rate: 885/2808 - My Submissions
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

package Permutations;

import java.util.ArrayList;

// AC on 1st try :)
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return res;
        tryNext(res, num, 0, new int[num.length], new boolean[num.length]);
        return res;
    }
    
    public void tryNext(ArrayList<ArrayList<Integer>> res, int[] num, int level, int[] have, boolean[] used) {
        if(level == num.length) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < num.length; i++) {
                list.add(have[i]);
            }
            res.add(list);
            return;
        }
        for(int i = 0; i < num.length; i++) {
            if(!used[i]) {
                used[i] = true;
                have[level] = num[i];
                tryNext(res, num, level+1, have, used);
                used[i] = false;
            }
        }
    }
}

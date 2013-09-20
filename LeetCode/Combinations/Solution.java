/*
 * Combinations AC Rate: 126/357 My Submissions
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */

package Combinations;

import java.util.ArrayList;

// AC on 2nd try :( forgot to use n to restrict the search space...
public class Solution {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		findCombine(1, n, new int[k], 0, k, res);
		return res;
	}
	
	public void findCombine(int cur, int n, int[] has, int pos, int k, 
			ArrayList<ArrayList<Integer>> res) {
		if(pos == k) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < pos; i++) list.add(has[i]);
			res.add(list);
			return;
		}
		if(cur > n) return;
		findCombine(cur+1, n, has, pos, k, res);
		has[pos] = cur;
		findCombine(cur+1, n, has, pos+1, k, res);
	}
}

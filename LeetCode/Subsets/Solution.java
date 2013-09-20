/*
 * Subsets AC Rate: 142/488 My Submissions
Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */

package Subsets;

import java.util.ArrayList;

// AC on 2nd try... silly in 1st try... just forgot it :(
public class Solution {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(S == null || S.length == 0) return res;
		quicksort(S, 0, S.length - 1);
		findSubset(S, 0, new int[S.length], 0, res);
		return res;
	}
	
	public void findSubset(int[] S, int cur, int[] has, int pos, ArrayList<ArrayList<Integer>> res) {
		if(cur == S.length) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < pos; i++) list.add(has[i]);
			res.add(list);
			return;
		}
		findSubset(S, cur+1, has, pos, res);
		has[pos] = S[cur];
		findSubset(S, cur+1, has, pos+1, res);
	}
	
	public void quicksort(int[] S, int start, int end) {
		int i = start, j = end;
		int temp = S[start];
		
		while(i < j) {
			while(i < j && S[j] > temp) j--;
			if(i < j) {
				S[i] = S[j];
				i++;
			}
			while(i < j && S[i] < temp) i++;
			if(i < j) {
				S[j] = S[i];
				j--;
			}
		}
		S[i] = temp;
		
		if(start < i-1) quicksort(S, start, i-1);
		if(i+1 < end) quicksort(S, i+1, end);
	}
}

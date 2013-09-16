/*
 * Subsets II - Jun 25 '12 - 4769 / 13419
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */

package Subsets2;

import java.util.ArrayList;

// AC on 2nd try :( forgot the empty list
public class Solution {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length == 0) return res;
		quicksort(0, num.length-1, num);
		findAllSubset(num, res, new int[num.length], 0, 0);
		return res;
	}
	
	public void findAllSubset(int[] num, ArrayList<ArrayList<Integer>> res, int[] temp, 
			int cur, int pos) {
		if(cur == num.length) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < pos; i++) list.add(temp[i]);
			res.add(list);
			return;
		}
		int count = 1, base = num[cur];
		for(cur = cur + 1; cur < num.length && num[cur] == base; cur++) count++;
		findAllSubset(num, res, temp, cur, pos); // bug: forgot the empty one
		for(int i = 0; i < count; i++) {
			temp[pos+i] = base;
			findAllSubset(num, res, temp, cur, pos+i+1);
		}
	}
	
	public void quicksort(int s, int t, int[] num) {
		int i = s, j = t;
		int temp = num[i];
		
		while(i < j) {
			while(i < j && num[j] > temp) j--;
			if(i < j) {
				num[i] = num[j];
				i++;
			}
			while(i < j && num[i] < temp) i++;
			if(i < j) {
				num[j] = num[i];
				j--;
			}
		}
		num[i] = temp;
		if(s < i-1) quicksort(s, i-1, num);
		if(i+1 < t) quicksort(i+1, t, num);
	}
}

/*
 * Permutations II - AC Rate: 617/2200 - My Submissions
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
 */

package Permutations2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// AC on 2nd try... The 1st is to verify, I cannot iterate the map, when I'm also changing the map
// A little concern, as each recursion need to copy a set of int
public class Solution {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length == 0) return res;
		Map<Integer, Integer> num2count = new HashMap<Integer, Integer>();
		for(int temp : num) {
			if(num2count.containsKey(temp)) num2count.put(temp, num2count.get(temp)+1);
			else num2count.put(temp, 1);
		}
		tryNext(res, num2count, new int[num.length], 0);
		return res;
	}
	
	public void tryNext(ArrayList<ArrayList<Integer>> res, Map<Integer, Integer> num2count,
			int[] has, int cur) {
		if(cur == has.length) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int temp : has) list.add(temp);
			res.add(list);
			return;
		}
		Set<Integer> current = new HashSet<Integer>();
		current.addAll(num2count.keySet());
		for(int temp : current) {
			has[cur] = temp;
			if(num2count.get(temp) == 1) num2count.remove(temp);
			else num2count.put(temp, num2count.get(temp) - 1);
			tryNext(res, num2count, has, cur+1);
			if(num2count.containsKey(temp)) num2count.put(temp, num2count.get(temp) + 1);
			else num2count.put(temp, 1);
		}
	}
}

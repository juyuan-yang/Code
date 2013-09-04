/*
 * Longest Consecutive Sequence - Feb 14 - 7913 / 22936
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */

package LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int longestConsecutive(int[] num) {
		if(num == null || num.length == 0) return 0;
		
		int max = 0;
		Set<Integer> set = new HashSet<Integer>();
		for(int n : num) set.add(n);
		for(int n : num) {
			if(set.contains(n)) {
				set.remove(n);
				int res = 1 + search(n+1, set, true) + search(n-1, set, false);
				if(res > max) max = res;
			}
		}
		return max;
	}
	
	public int search(int n, Set<Integer> set, boolean increase) {
		int total = 0;
		while(set.contains(n)) {
			total++;
			set.remove(n);
			if(increase) n++;
			else n--;
		}
		return total;
	}
}

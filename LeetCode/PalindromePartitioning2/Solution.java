/*
 * Palindrome Partitioning II - Mar 1 - 13297 / 47208
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */

package PalindromePartitioning2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Changed from problem 1, but get WA as forget to minus one
// Then get Time Limit Exceed on 2nd try
// Finally find that I should use DP!!! How silly at the 1st time
public class Solution {
	public int minCut(String s) {
		if(s != null && s.length() > 0) {
			Map<Integer, List<Integer>> map = generateMap(s);
			int[] res = new int[s.length() + 1];
			for(int i = 0; i < s.length(); i++) {
				if(i == 0 || res[i] > 0) {
					for(int length : map.get(i)) {
						if(res[i + length] == 0 || res[i] + 1 < res[i + length]) {
							res[i + length] = res[i] + 1;
						}
					}
				}
			}
			return res[s.length()];
		}
		return 0;
	}
	
	public Map<Integer, List<Integer>> generateMap(String s) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i = 0; i < s.length(); i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(1);
			map.put(i, list);
			tryMorePalindrome(s, i - 1, i + 1, map);
			tryMorePalindrome(s, i, i + 1, map);
		}
		return map;
	}
	
	public void tryMorePalindrome(String s, int begin, int end, Map<Integer, List<Integer>> map) {
		if(begin >= 0 && end < s.length()) {
			if(s.charAt(begin) == s.charAt(end)) {
				map.get(begin).add(end - begin + 1);
				tryMorePalindrome(s, begin - 1, end + 1, map);
			}
		}
	}
}

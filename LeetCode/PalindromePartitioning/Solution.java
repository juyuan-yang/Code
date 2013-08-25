/*
 * Palindrome Partitioning - Feb 28 - 7285 / 24780
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 */

package PalindromePartitioning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// AC first time! so exciting!
// I have tried my best to short the code! I think it's a good job :)
public class Solution {
	ArrayList<ArrayList<String>> res;
	int[] pos;
	public ArrayList<ArrayList<String>> partition(String s) {
		res = new ArrayList<ArrayList<String>>();
		if(s != null && s.length() > 0) {
			Map<Integer, List<Integer>> map = generateMap(s);
			pos = new int[s.length() + 1];
			tryPartition(s, 0, 0, map, res);
		}
		return res;
	}
	
	public void tryPartition(String s, int begin, int count, Map<Integer, List<Integer>> map,
			ArrayList<ArrayList<String>> res) {
		if(begin == s.length()) {
			ArrayList<String> list = new ArrayList<String>();
			for(int i = 0; i < count; i++) {
				String str = s.substring(pos[i], pos[i + 1]);
				list.add(str);
			}
			res.add(list);
			return;
		}
		for(int palinLength : map.get(begin)) {
			pos[count + 1] = begin + palinLength;
			tryPartition(s, begin + palinLength, count + 1, map, res);
		}
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

/*
 * Anagrams - AC Rate: 587/2416 - My Submissions
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
 */

package Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// AC on 1st try :)
public class Solution {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> res = new ArrayList<String>();
		if(strs == null || strs.length == 0) return res;
		
		Map<String, String> sort2orig = new HashMap<String, String>();
		Set<String> sortWords = new HashSet<String>();
		
        for(String str : strs) {
        	String sort = sortWord(str);
        	if(!sortWords.contains(sort)) {
        		if(!sort2orig.containsKey(sort)) {
        			sort2orig.put(sort, str);
        		} else {
        			res.add(str);
        			sortWords.add(sort);
        			res.add(sort2orig.get(sort));
        			sort2orig.remove(sort);
        		}
        	} else {
        		res.add(str);
        	}
        }
        return res;
	}
	
	public String sortWord(String orig) {
		int[] nums = new int[26];
		for(int i = 0; i < orig.length(); i++) {
			nums[orig.charAt(i) - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 26; i++) {
			while(nums[i] > 0) {
				sb.append('a' + i);
				nums[i]--;
			}
		}
		
		return sb.toString();
	}
}

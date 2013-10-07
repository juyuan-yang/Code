/*
 * Anagrams - AC Rate: 587/2416 - My Submissions
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
 */

package Anagrams;

import java.util.ArrayList;

public class Solution {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> res = new ArrayList<String>();
        for(String str : strs) res.add(str);
        return res;
	}
}

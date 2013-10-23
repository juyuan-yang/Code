/*
 * Substring with Concatenation of All Words - AC Rate: 492/3366 My Submissions
You are given a string, S, and a list of words, L, that are all of the same length. 
Find all starting indices of substring(s) in S that is a concatenation of each word 
in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 */

package SubstringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// AC on 3rd try :(
public class Solution {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Map<String, Integer> word2count = new HashMap<String, Integer>(); // should use map, as there may be duplicates...
		for(String word : L) {
			if(word2count.containsKey(word))
				word2count.put(word, word2count.get(word) + 1);
			else word2count.put(word, 1);
		}
		int wordLen = L[0].length();
		
		for(int i = 0; i <= S.length() - L.length * wordLen; i++) { // bug, should be <=
			Map<String, Integer> temp = new HashMap<String, Integer>();
			temp.putAll(word2count);
			for(int j = i; j < i + L.length * wordLen; j += wordLen) {
				String word = S.substring(j, j + wordLen);
				if(temp.containsKey(word)) {
					int count = temp.get(word);
					if(count == 1) temp.remove(word);
					else temp.put(word, count - 1);
				} else break;
			}
			if(temp.isEmpty()) res.add(i);
		}
		return res;
	}
}

/*
 * Minimum Window Substring - AC Rate: 206/1091 - My Submissions
Given a string S and a string T, find the minimum window in S which will contain 
all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only 
one unique minimum window in S.
 */

package MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

// AC on 4th try :( Anyway it's O(n), rather than O(n*m)
// n -> S.length(), m -> T.length()
public class Solution {
    public String minWindow(String S, String T) {
		Map<Character, Integer> ch2count = new HashMap<Character, Integer>();
		for(int i = 0; i < T.length(); i++) {
			char ch = T.charAt(i);
			if(ch2count.containsKey(ch)) {
				ch2count.put(ch, ch2count.get(ch) + 1);
			} else ch2count.put(ch, 1);
		}
		
		int nonZero = ch2count.size(), start = 0;
		while(start < S.length() && !ch2count.containsKey(S.charAt(start))) start++; // bug, forgot to initialize
		String res = "";
		for(int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			if(ch2count.containsKey(ch)) {
				int count = ch2count.get(ch);
				ch2count.put(ch, count - 1);
				if(count == 1) nonZero--;
			}
			while(start < i) { // bug, need to move start as much as possible
				ch = S.charAt(start);
				if(ch2count.containsKey(ch) && ch2count.get(ch) < 0) {
					ch2count.put(ch, ch2count.get(ch) + 1);
					start++;
				} else if(!ch2count.containsKey(ch)) {
				    start++;
				} else break;
			}
			if(nonZero == 0) {
				if(res.equals("") || i + 1 - start < res.length()) 
					res = S.substring(start, i + 1);
				while(start < i) {
					ch = S.charAt(start);
					if(ch2count.containsKey(ch)) {
						if(nonZero != 0) break; // bug, need to move start as much as possible
						int count = ch2count.get(ch);
						ch2count.put(ch, count + 1);
						if(count == 0) nonZero++;
					}
					start++;
				}
			}
		}
		return res;
    }
}

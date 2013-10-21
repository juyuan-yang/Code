/*
 * Longest Substring Without Repeating Characters - AC Rate: 1968/8293 My Submissions
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */

package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

// AC on 2nd try :( silly mistake
public class Solution {
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        
        Set<Character> chs = new HashSet<Character>();
        int start = 0, res = 1;
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(chs.contains(ch)) {
                while(s.charAt(start) != ch && start != i) {
                	chs.remove(s.charAt(start));
                	start++;
                }
                start++;
            } else {
                chs.add(ch);
                if(i - start + 1 > res) res = i - start + 1;
            }
        }
        
        return res;
	}
}

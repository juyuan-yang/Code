/*
 * Regular Expression Matching - AC Rate: 1050/5440 My Submissions
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 */

package RegularExpressionMatching;

// AC after several tries :( see comments
public class Solution {
	public static void main(String[] args) {
		Solution s= new Solution();
		s.isMatch("aab", "c*a*b");
	}
	
	public boolean isMatch(String s, String p) {
		
		return isMatch(s, p, 0, 0);
	}
	
	public boolean isMatch(String s, String p, int i, int j) {
		if(i == s.length()) {
		    if(j == p.length()) return true;
		    else if(j + 1 < p.length() && p.charAt(j+1) == '*') return isMatch(s, p, i, j+2); // bug, forgot to check this situation
		    else return false;
		}
		
		while(j + 1 == p.length() || (j + 1 < p.length() && p.charAt(j+1) != '*')) {
			if(p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			} else return false;
			if(i == s.length()) return isMatch(s, p, i, j); // bug, forgot to check i
		} 
		if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
			if(p.charAt(j) != '.' && s.charAt(i) != p.charAt(j)) {
				return isMatch(s, p, i, j + 2);
			} else {
				while(i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) { // bug, forgot to check after i++
					if(isMatch(s, p, i, j + 2)) return true;
					else i++;
				}
				return isMatch(s, p, i, j + 2); // bug, need to check again when i == s.length
			}
		}
		
		if(j == p.length()) return i == s.length();
		return false;
	}
}

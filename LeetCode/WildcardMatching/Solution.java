/*
 * Wildcard Matching - AC Rate: 379/3849 - My Submissions
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") �� false
isMatch("aa","aa") �� true
isMatch("aaa","aa") �� false
isMatch("aa", "*") �� true
isMatch("aa", "a*") �� true
isMatch("ab", "?*") �� true
isMatch("aab", "c*a*b") �� false
 */

package WildcardMatching;

public class Solution {
	// my version... almost copy, but just try to do it all myself
	public boolean isMatch(String s, String p) {
		if(p == null || p.isEmpty()) return (s == null || s.isEmpty());
		if(s == null || s.isEmpty()) {
			for(int i = 0; i < p.length(); i++) 
				if(p.charAt(i) != '*') return false;
			return true;
		}
		
		int i = 0, j = 0;
		int lastStar = -1, pre = -1;
		
		while(i < s.length()) {
			char sc = (i == s.length() ? '\0' : s.charAt(i));
			char pc = (j == p.length() ? '\0' : p.charAt(j));
			
			if(sc == pc || pc == '?') {
				i++;
				j++;
			} else if(pc == '*') {
				lastStar = j;
				pre = i;
				j++;
			} else if(lastStar != -1) {
				i = ++pre;
				j = lastStar + 1;
			} else return false;
		}
		
		while(j < p.length()) {
			if(p.charAt(j++) != '*') return false;
		}
		
		return true;
	}
	
	// version from yxyxyx
	public boolean isMatch_YX(String s, String p) {
		if(p == null || p.length() == 0) return (s == null || s.length() == 0);
		
		s = s + '\0';
		p = p + '\0';
		
		int sb = 0, pb = 0, pre = -1, lastStar = -1;
		while(sb < s.length() && s.charAt(sb) != '\0') {
			char sc = s.charAt(sb), pc = p.charAt(pb);
			if(pc == '?' || sc == pc) {
				sb++;
				pb++;
			} else if(pc == '*') {
				pre = sb;
				lastStar = pb;
				pb++;
			} else if(lastStar != -1){
				pb = lastStar + 1;
				sb = pre + 1;
				pre++;
			} else return false;
		}
		
		while(pb < p.length()) {
			if(p.charAt(pb) != '*' && p.charAt(pb) != '\0') return false;
			else pb++;
		}
		
		return true;
	}
}

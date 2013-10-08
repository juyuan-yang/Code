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
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isMatch("", "*"));
	}
	
	public boolean isMatch(String s, String p) {
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

/*
 * Longest Palindromic Substring - AC Rate: 1589/7255 My Submissions
Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, 
and there exists one unique longest palindromic substring.
 */

package LongestPalindromicSubstring;

// AC on 1st try :)
public class Solution {
	public String longestPalindrome(String s) {
		if(s == null || s.length() == 0) return "";
		String res = s.substring(0, 1);
		
		for(int i = 0; i < s.length() - 1; i++) {
			int j = 1;
			while(i - j >= 0 && i + j < s.length()) {
				if(s.charAt(i-j) != s.charAt(i+j)) break;
				else if(2*j + 1 > res.length()) {
					res = s.substring(i-j, i+j+1);
				}
				j++;
			}
			if(s.charAt(i) == s.charAt(i+1)) {
				if(res.length() < 2) res = s.substring(i, i+2);
				j = 1;
				while(i - j >= 0 && i + j + 1 < s.length()) {
					if(s.charAt(i-j) != s.charAt(i+j+1)) break;
					else if(2*j+2 > res.length()) {
						res = s.substring(i-j, i+j+2);
					}
					j++;
				}
			}
		}
		
		return res;
	}
}

/*
 * Interleaving String - Aug 31 '12 - 7096 / 24208
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 */

package InterleavingString;

// AC on 1st try :) to iterate using k is a good idea
public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1 == null || s2 == null || s3 == null) return false;
		if(s1.length() + s2.length() != s3.length()) return false;
		if(s1.length() == 0) return s2.equals(s3);
		if(s2.length() == 0) return s1.equals(s3);
		
		boolean[][] res = new boolean[s1.length() + 1][s2.length() + 1];
		res[0][0] = true;
		
		for(int k = 1; k <= s3.length(); k++)
			for(int i = 0; i <= s1.length(); i++) {
				int j = k - i;
				if(j < 0 || j > s2.length()) continue;
				if(i > 0 && s3.charAt(k-1) == s1.charAt(i-1)) res[i][j] |= res[i-1][j];
				if(j > 0 && s3.charAt(k-1) == s2.charAt(j-1)) res[i][j] |= res[i][j-1];
			}
		
		return res[s1.length()][s2.length()];
	}
}

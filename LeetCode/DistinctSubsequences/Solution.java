/*
 * Distinct Subsequences - Oct 19 '12 - 6266 / 17972
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string 
by deleting some (can be none) of the characters without disturbing the relative positions 
of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
 */

package DistinctSubsequences;

public class Solution {
	// AC on 2nd try? But I don't understand what I'm writing :(((
	// why?
	public int numDistinct(String S, String T) {
		if(S == null || S.length() == 0) return 0;
		if(T == null || T.length() == 0) return S.length();
		
		int[][] res = new int[T.length()+1][S.length()+1];
		for(int j = 0; j < S.length(); j++) res[0][j] = 1;
		
		for(int i = 0; i < T.length(); i++)
			for(int j = 0; j < S.length(); j++){
				res[i+1][j+1] = res[i+1][j];
				if(T.charAt(i) == S.charAt(j)) {
					res[i+1][j+1] += res[i][j];
				}
			}
		
		return res[T.length()][S.length()];
	}
}

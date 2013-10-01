/*
 * Edit Distance - AC Rate: 254/1033 - My Submissions
Given two words word1 and word2, find the minimum number of steps required to 
convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
 */

package EditDistance;

public class Solution {
	public int minDistance(String word1, String word2) {
		if(word1 == null && word2 == null) return 0;
		else if(word1 == null) return word2.length();
		else if(word2 == null) return word1.length();
		
		if(word1.length() == 0) return word2.length();
		if(word2.length() == 0) return word1.length();
		
		int[][] res = new int[word1.length()+1][word2.length()+1];
		
		for(int i = 1; i <= word1.length(); i++)
			for(int j = 1; j <= word2.length(); j++){
				if(word1.charAt(i-1) == word2.charAt(j-1)) res[i][j] = res[i-1][j-1];
				else res[i][j] = res[i-1][j-1] + 1;
			}
		
		return res[word1.length()][word2.length()];
	}
}

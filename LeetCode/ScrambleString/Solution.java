/*
 * Scramble String - Apr 30 '12 - 4644 / 14931
Given a string s1, we may represent it as a binary tree 
by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, 
it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", 
it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */

package ScrambleString;

// AC on 2nd try :( made a mistake when updating notZero counter...
public class Solution {
	public boolean isScramble(String s1, String s2) {
		if(s1 == null && s2 == null) return true;
		else if(s1 == null) return s2.length() == 0;
		else if(s2 == null) return s1.length() == 0;
		
		return isScramble(s1, s2, 0, 0, s1.length());
	}
	
	public boolean isScramble(String s1, String s2, int b1, int b2, int l) {
		if(l == 0) return true;
		else if(l == 1) return s1.charAt(b1) == s2.charAt(b2);
		
		int[] counter = new int[128];
		int notZero = 0;
		for(int i = 0; i < l - 1; i++) {
			if(counter[s1.charAt(b1 + i)] == -1) notZero--;
			else if(counter[s1.charAt(b1 + i)] == 0) notZero++;
			counter[s1.charAt(b1 + i)]++;
			
			if(counter[s2.charAt(b2 + i)] == 1) notZero--;
			else if(counter[s2.charAt(b2 + i)] == 0) notZero++;
			counter[s2.charAt(b2 + i)]--;
			
			if(notZero == 0){
				if(isScramble(s1, s2, b1, b2, i+1) && isScramble(s1, s2, b1+i+1, b2+i+1, l-i-1)) 
					return true;
			}
		}
		
		counter = new int[128];
		notZero = 0;
		for(int i = 0; i < l - 1; i++) {
			if(counter[s1.charAt(b1 + i)] == -1) notZero--;
			else if(counter[s1.charAt(b1 + i)] == 0) notZero++;
			counter[s1.charAt(b1 + i)]++;
			
			if(counter[s2.charAt(b2 + l - 1 - i)] == 1) notZero--;
			else if(counter[s2.charAt(b2 + l - 1 - i)] == 0) notZero++;
			counter[s2.charAt(b2 + l - 1 - i)]--;
			
			if(notZero == 0){
				if(isScramble(s1, s2, b1, b2+l-1-i, i+1) && isScramble(s1, s2, b1+i+1, b2, l-i-1)) 
					return true;
			}
		}
		
		return false;
	}
}

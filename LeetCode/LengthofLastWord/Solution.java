/*
 * Length of Last Word - AC Rate: 482/1638 - My Submissions
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
 */

package LengthofLastWord;

// AC on 1st try :)
public class Solution {
	public int lengthOfLastWord(String s) {
		if(s == null || s.length() == 0) return 0;
		int res = 0;
		boolean checking = false;
		
		for(int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				if(!checking) checking = true;
				res++;
			} else if(checking){
				return res;
			}
		}
		return res;
	}
}

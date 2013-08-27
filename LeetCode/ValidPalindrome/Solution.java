/*
 * Valid Palindrome - Jan 13 - 7412 / 23481
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */

package ValidPalindrome;

// AC on 3rd try :(
public class Solution {
	public boolean isPalindrome(String s) {
		if(s == null || s.length() == 0) return true;
		int start = -1, end = s.length(); // bug2: forget to change 0 to -1, after fix bug1
		while(start < end) {
			start = findNext(s, start + 1, true); // bug1: forget to +1, so endless loop...
			end = findNext(s, end - 1, false);
			if(start < end) {
				if(!isEqual(s, start, end)) return false;
			}
		}
		return true;
	}
	
	public int findNext(String s, int index, boolean increase) {
		while(index >= 0 && index < s.length()) {
			char ch = s.charAt(index);
			if(ch >= '0' && ch <= '9') return index;
			else if(ch >= 'a' && ch <= 'z') return index;
			else if(ch >= 'A' && ch <= 'Z') return index;
			if(increase) index++;
			else index--;
		}
		return -1;
	}
	
	public boolean isEqual(String s, int i, int j) {
		if(i == j) return true;
		char ch1 = s.charAt(i), ch2 = s.charAt(j);
		if(ch1 >= 'a' && ch1 <= 'z') ch1 += 'A' - 'a';
		if(ch2 >= 'a' && ch2 <= 'z') ch2 += 'A' - 'a';
		return ch1 == ch2;
	}
}

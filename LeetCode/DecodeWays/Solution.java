/*
 * Decode Ways - Jun 25 '12 - 6747 / 26583
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 */

package DecodeWays;

// AC on 2nd try :( a silly mistake
public class Solution {
	public int numDecodings(String s) {
		if(s == null || s.length() == 0) return 0;
		int[] res = new int[s.length()+1];
		res[0] = 1; // bug: forgot this initialization
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != '0') res[i+1] = res[i];
			else if(i == 0) return 0;
			if(i > 1) {
				int num = Integer.parseInt(s.substring(i-1, i+1));
				if(num <= 26 && num >= 10) res[i+1] += res[i-1];
			}
		}
		return res[s.length()];
	}
}

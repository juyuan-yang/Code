/*
 * Add Binary - AC Rate: 400/1474 - My Submissions
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */

package AddBinary;

// AC on 2nd try :(, I wrote && instead of || in 1st try
public class Solution {
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		if(a == null || b == null) return "";
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		
		while(i >= 0 || j >= 0) {
			int temp = carry;
			if(i >= 0 && a.charAt(i) == '1') temp++;
			if(j >= 0 && b.charAt(j) == '1') temp++;
			carry = (temp > 1) ? 1 : 0;
			sb.append(temp % 2);
			i--;
			j--;
		}
		
		if(carry > 0) sb.append(1);
		return sb.reverse().toString();
	}
}

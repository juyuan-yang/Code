/*
 * String to Integer (atoi) - AC Rate: 1305/8816 My Submissions
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, 
please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
You are responsible to gather all the input requirements up front.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the 
first non-whitespace character is found. Then, starting from this character, 
takes an optional initial plus or minus sign followed by as many numerical digits as possible, 
and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, 
which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, 
or if no such sequence exists because either str is empty or it contains only whitespace characters, 
no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is 
out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */

package StringtoInteger_atoi;

// AC on 3rd try, but it is because of typo =.=... For edge cases, I follow the instruction from this problem,
// but I should define it myself at the beginning of the interview
public class Solution {
	public int atoi(String str) {
		if(str == null) return 0;
		str = str.trim();
		if(str.length() == 0) return 0;
		
		boolean neg = false;
		if(str.charAt(0) == '-') {
			neg = true;
			str = str.substring(1);
		} else if(str.charAt(0) == '+') {
			str = str.substring(1);
		}
		
		int res = 0, pos = 0;
		while(pos < str.length()) {
			char ch = str.charAt(pos);
			if(ch >= '0' && ch <= '9') {
				int temp = ch - '0';
				if(neg) {
					if(res < (Integer.MIN_VALUE + temp) / 10) return Integer.MIN_VALUE;
					res = res * 10 - temp;
				} else {
					if(res > (Integer.MAX_VALUE - temp) / 10) return Integer.MAX_VALUE;
					res = res * 10 + temp;
				}
			} else break;
			pos++;
		}
		return res;
	}
}

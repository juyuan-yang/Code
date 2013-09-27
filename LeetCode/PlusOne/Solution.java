/*
 * Plus One - AC Rate: 380/1224 - My Submissions
Given a number represented as an array of digits, plus one to the number.
 */

package PlusOne;

// AC on 2nd try, but it's not my problem! As the number for 10 is represented as [1, 0]
public class Solution {
	public int[] plusOne(int[] digits) {
		if(digits == null || digits.length == 0) return null;
		int carry = 1;
		for(int i = digits.length - 1; i >= 0; i--) {
			digits[i] += carry;
			if(digits[i] == 10) {
				digits[i] = 0;
				carry = 1;
			} else carry = 0;
		}
		if(carry == 0) return digits;
		else {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			return res;
		}
	}
}

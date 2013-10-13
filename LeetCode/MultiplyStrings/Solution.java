/*
 * Multiply Strings - AC Rate: 469/2552 My Submissions
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
 */

package MultiplyStrings;

// AC after several tries :(... so many silly mistakes
public class Solution {
	public String multiply(String num1, String num2) {
		if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return "0";
		
		int[] n1 = numberConvertor(num1), n2 = numberConvertor(num2);
		int[] bits = new int[n1.length + n2.length + 1];
		
		for(int i = 0; i < n1.length; i++)
			for(int j = 0; j < n2.length; j++) {
				int temp = i + j;
				bits[temp] += n1[i] * n2[j];
				while(bits[temp] > 9999) {
					bits[temp+1] += bits[temp] / 10000;
					bits[temp] %= 10000;
					temp++;
				}
			}
		
		StringBuilder sb = new StringBuilder();
		int index = bits.length - 1;
		while(bits[index] == 0 && index > 0) index--;
		sb.append(bits[index--]);
		
		for(int i = index; i >= 0; i--) {
			if(bits[i] < 1000) sb.append("0");
			if(bits[i] < 100) sb.append("0");
			if(bits[i] < 10) sb.append("0");
			sb.append(bits[i]);
		}
		
		return sb.toString();
	}
	
	public int[] numberConvertor(String num) {
		int[] bits = new int[(num.length() + 3) / 4];
		for(int i = num.length(), temp = 0; i > 0; i -= 4) {
			bits[temp++] = Integer.parseInt(num.substring(((i-4 > 0) ? i-4 : 0), i));
		}
		return bits;
	}
}

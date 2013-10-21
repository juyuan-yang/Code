/*
 * Divide Two Integers - AC Rate: 994/6775 My Submissions
Divide two integers without using multiplication, division and mod operator.
 */

package DivideTwoIntegers;

// AC after several tries :(
public class Solution {
	public int divide(int dividend, int divisor) {
		if(dividend == 0) return 0;
		
		boolean neg = (dividend > 0) ^ (divisor > 0); // bug
		if(dividend > 0) dividend = -dividend;
		if(divisor > 0) divisor = -divisor;
		
        int temp = divisor, res = 0, cur = -1; // bug, cur should also use negative, in case Min_Int
        
        while(dividend >> 1 <= temp) { // bug, need to use <= here, rather than < 
            temp = temp << 1;
            cur = cur << 1;
        }
        
        while(dividend < 0) {
        	if(dividend <= temp) {
        		dividend -= temp;
        		res += cur;
        	}
        	if(cur == -1) cur = 0; // bug, -1 >> 1 = -1...
        	else cur = cur >> 1;
            temp = temp >> 1;
        }
		
        if(neg) return res;
        else return -res;
	}
}

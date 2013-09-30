/*
 * Sqrt(x) AC Rate: 460/2165 My Submissions
Implement int sqrt(int x).

Compute and return the square root of x.
 */

package SqrtX;

public class Solution {
	// Use Newton's method http://en.wikipedia.org/wiki/Newton%27s_method
	// Ac on 2nd try :(
	public int sqrt(int x) {
		if(x <= 0) return 0;
		if(x == 1) return 1;
		
		int res = x / 2, pre = -1;
		while(res != pre) {
			pre = res;
			res = (res + x / res) / 2;
			if(res > pre) return pre; // bug here, forgot to add this
		}
		return res;
	}
	
	// Use binary search, AC on 1st try :)
	public int sqrt_BS(int x) {
		if(x <= 0) return 0;
		if(x == 1) return 1;
		
		int start = 1, end = x / 2;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(mid == x / mid) return mid;
			else if(mid > x / mid) end = mid - 1;
			else start = mid + 1;
		}
		
		return end;
	}
}

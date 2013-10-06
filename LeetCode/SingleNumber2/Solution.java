/*
 * Single Number II - AC Rate: 10/45 - My Submissions
Given an array of integers, every element appears three times except for one. 
Find that single one.

Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?
 */

package SingleNumber2;

// AC after several times :( Actually, the simple version should be correct,
// just need to indicate 32 bits instead of 64 bits
public class Solution {
	// A simple version
    public int singleNumber(int[] A) {
		if(A == null || A.length == 0) return 0;
		int res = 0, mark = 0;
		
		while(mark < 32) {
			int count = 0;
			boolean finished = true;
			for(int i = 0; i < A.length; i++) {
				if((A[i] >> mark & 1) == 1) count++;
				if(A[i] >> mark != 0) finished = false;
			}
			if(count % 3 == 1) {
				res += 1 << mark;
			}
			if(finished) break;
			mark++;
		}
		return res;
    }
	
	// A complete version...
	public int singleNumber1(int[] A) {
		if(A == null || A.length == 0) return 0;
		int res = 0, mark = 0;
		
		while(mark < 32) {
			int temp = checkBit(A, mark);
			if(temp == 1) res += (1 << mark);
			else if(temp == -1) break;
			mark++;
		}
	
		return res;
	}
	
	// return 1, if this bit is in target
	// return 0, if not
	// return -1, if no need to try more bits, could stop now
	public int checkBit(int[] A, int mark) {
		int count = 0;
		boolean finished = true;
		for(int i = 0; i < A.length; i++) {
			int temp = A[i] >> mark;
			if((temp & 1) == 1) count++;
			if(temp != 0) finished = false;
		}
		if(count % 3 == 1) return 1;
		else if(finished) return -1;
		else return 0;
	}
}

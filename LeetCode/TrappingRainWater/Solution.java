/*
 * Trapping Rain Water - AC Rate: 632/2344 My Submissions
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped. 
Thanks Marcos for contributing this image!
 */

package TrappingRainWater;

import java.util.Stack;

// AC after several tries :(
public class Solution {
	public int trap(int[] A) {
		if(A == null || A.length == 0) return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int res = 0, i = 0;
		while(i < A.length) {
			if(stack.isEmpty()) {
				if(A[i] > 0) stack.add(i++);
				else i++; // bug, forgot this
			} else if(A[i] < A[stack.peek()]) {
				stack.add(i++);
			} else if(A[i] >= A[stack.peek()]) { // bug, need = here
				int pre = stack.pop();
				if(stack.isEmpty()) {
					stack.add(i++);
				} else {
					int height = (Math.min(A[i], A[stack.peek()])) - A[pre];
					res += height * (i - 1 - stack.peek());
				}
			}
		}
		return res;
	}
}

/*
 * Largest Rectangle in Histogram - Apr 23 '12 - 6550 / 21145
Given n non-negative integers representing the histogram's bar height 
where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit. 
(5 and 6, with length 2)

For example,
Given height = [2,1,5,6,2,3],
return 10.
 */

package LargestRectangleinHistogram;

import java.util.Stack;

// AC on 2nd try :( actually, it's hard to come up the algorithm all by myself
public class Solution {
	public int largestRectangleArea(int[] height) {
		if(height == null || height.length == 0) return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0, res = 0, i = 0;
		
		while(i <= height.length) {
			if(stack.isEmpty() || (i < height.length && height[i] >= height[stack.peek()])) 
				stack.add(i++);
			else {
				res = height[stack.pop()];
				res *= (stack.isEmpty() ? i : (i - 1 - stack.peek()));
				if(res > max) max = res;
			}
		}
		return max;
	}
}

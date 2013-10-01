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

public class Solution {
	public int largestRectangleArea(int[] height) {
		if(height == null || height.length == 0) return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int res = height[0];
		
		for(int i = 0; i < height.length; i++) {
			if(stack.size() == 0) stack.add(i);
			else {
				int index = stack.peek();
				if(height[i] >= height[index]) stack.add(i);
				else {
					stack.pop();
					
				}
			}
		}
		return res;
	}
}

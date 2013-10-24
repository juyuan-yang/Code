/*
 * Container With Most Water - AC Rate: 1296/4302 My Submissions
Given n non-negative integers a1, a2, ..., an, 
where each represents a point at coordinate (i, ai). n vertical lines are drawn such that 
the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
 */

package ContainerWithMostWater;

// AC on 1st try
public class Solution {
	public int maxArea(int[] height) {
        if(height == null || height.length < 2) return 0;
        int max = 0, start = 0, end = height.length - 1;
        
        while(start < end) {
            int temp;
            if(height[start] < height[end]) {
                temp = (end - start) * height[start];
                start++;
            } else {
                temp = (end - start) * height[end];
                end--;
            }
            if(temp > max) max = temp;
        }
        return max;
	}
}

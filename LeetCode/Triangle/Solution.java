/*
 * Triangle - Oct 30 '12 - 6503 / 17796
Given a triangle, find the minimum path sum from top to bottom. 
Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, 
where n is the total number of rows in the triangle.
 */

package Triangle;

import java.util.ArrayList;

// AC on 1st try... but it took too long time to write!!!
public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if(triangle == null || triangle.size() == 0) return 0;
		
		int[] res = new int[triangle.size()];
		for(int i = triangle.size() - 1; i > 0; i--) {
			ArrayList<Integer> list = triangle.get(i);
			for(int j = 0; j < i; j++) {
				res[j] = getMin(res[j] + list.get(j), res[j+1] + list.get(j+1));
			}
		}
		return triangle.get(0).get(0) + res[0];
	}
	
	public int getMin(int num1, int num2) {
		return (num1 < num2) ? num1 : num2;
	}
}

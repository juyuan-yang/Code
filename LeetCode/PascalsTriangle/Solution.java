/*
 * Pascal's Triangle - Oct 28 '12 - 4857 / 10981
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
] 
 */

package PascalsTriangle;

import java.util.ArrayList;

// AC on 1st try
public class Solution {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	
		for(int i = 0; i < numRows; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			if(i > 0) {
				ArrayList<Integer> prev = res.get(i-1);
				list.add(prev.get(0));
				for(int j = 1; j < prev.size(); j++) {
					list.add(prev.get(j) + prev.get(j - 1));
				}
			}
			list.add(1);
			res.add(list);
		}
		
		return res;
	}
}

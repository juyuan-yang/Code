/*
 * Pascal's Triangle II - Oct 29 '12 - 5210 / 12287
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */

package PascalsTriangle2;

import java.util.ArrayList;

// AC on 1st try
public class Solution {
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int[] row = new int[rowIndex + 1];
		for(int i = 0; i <= rowIndex; i++) {
			row[i] = 1;
			for(int j = i-1; j > 0; j--) {
				row[j] += row[j-1];
			}
		}
		for(int i = 0; i <= rowIndex; i++) res.add(row[i]);
		return res;
	}
}

/*
 * Convert Sorted Array to Binary Search TreeOct 2 '125459 / 11289
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */

package ConvertSortedArraytoBinarySearchTree;

import Helper.TreeNode;

// AC on 1st try :)
public class Solution {
	public TreeNode sortedArrayToBST(int[] num) {
		if(num == null || num.length == 0) return null;
		return visit(num, 0, num.length - 1);
	}
	
	public TreeNode visit(int[] num, int start, int end) {
		int mid = start + (end - start) / 2;
		TreeNode node = new TreeNode(num[mid]);
		if(start < mid) node.left = visit(num, start, mid - 1);
		if(mid < end) node.right = visit(num, mid + 1, end);
		return node;
	}
}

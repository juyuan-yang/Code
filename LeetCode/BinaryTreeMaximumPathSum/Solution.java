/*
 * Binary Tree Maximum Path Sum - Nov 8 '12 - 7312 / 26768
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */

package BinaryTreeMaximumPathSum;

import Helper.TreeNode;

// AC on 2nd try
public class Solution {
	int res;
	public int maxPathSum(TreeNode root) {
		if(root == null) return 0;
		res = root.val;
		getMaxSoFar(root);
		return res;
	}
	
	public int getMaxSoFar(TreeNode node) {
		if(node == null) return 0;
		if(node.left == null && node.right == null) {
			if(node.val > res) res = node.val;	// 1st bug :(
			return node.val;
		}
		
		int left = getMaxSoFar(node.left);
		int right = getMaxSoFar(node.right);
		
		res = getMax(res, node.val + left + right);
		res = getMax(res, node.val + getMax(left, right));
		
		return node.val + getMax(0, getMax(left, right));
	}
	
	public int getMax(int a, int b) {
		return (a > b) ? a : b;
	}
}

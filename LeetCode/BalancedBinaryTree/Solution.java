/*
 * Balanced Binary Tree - Oct 9 '12 - 7722 / 18479
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree 
in which the depth of the two subtrees of every node never differ by more than 1.
 */

package BalancedBinaryTree;

import Helper.TreeNode;

// AC on 2nd try
// May meet Time Limit Exceed occasionally, so add a res == false check
// Still meet TLE sometimes ? :(
public class Solution {
	boolean	res;
	public boolean isBalanced(TreeNode root) {
		res = true;
		visit(root);
		return res;
	}
	
	public int visit(TreeNode node) {
		if(node == null) return 0;
		if(res == false) return -1;
		int left = visit(node.left);
		int right = visit(node.right);
		if(Math.abs(right - left) >= 2) res = false;
		return Math.max(left, right) + 1;
	}
}

/*
 * Maximum Depth of Binary Tree - Sep 30 '12 - 6343 / 9043
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along 
the longest path from the root node down to the farthest leaf node.
 */

package MaximumDepthofBinaryTree;

import Helper.TreeNode;

// AC on 2nd try :(
public class Solution {
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		return visit(root, 0);
	}
	
	public int visit(TreeNode node, int depth) {
		if(node.left == null && node.right == null) return depth + 1;
		else if(node.left == null) return visit(node.right, depth + 1); // a silly mistake here on 1st try :(
		else if(node.right == null) return visit(node.left, depth + 1);
		else {
			int left = visit(node.left, depth + 1);
			int right = visit(node.right, depth + 1);
			return (left > right) ? left : right;
		}
	}
}

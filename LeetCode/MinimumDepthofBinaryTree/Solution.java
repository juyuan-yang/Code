/*
 * Minimum Depth of Binary Tree - Oct 10 '12 - 7310 / 18192
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node 
down to the nearest leaf node.
 */

package MinimumDepthofBinaryTree;

import Helper.TreeNode;

// AC on 2nd try :(
public class Solution {
	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		return visit(root, 0);
	}
	
	public int visit(TreeNode node, int depth) {
		if(node.left == null && node.right == null) return depth + 1;
		else if(node.left == null) return visit(node.right, depth + 1);
		else if(node.right == null) return visit(node.left, depth + 1);
		else {
			int left = visit(node.left, depth + 1);
			int right = visit(node.right, depth + 1);
			return (left < right) ? left : right; // bug here for 1st try, no need to add 1
		}
	}
}

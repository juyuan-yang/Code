/*
 * Validate Binary Search Tree - Aug 31 '12 - 6761 / 19400
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */

package ValidateBinarySearchTree;

import Helper.TreeNode;

// AC on 2nd try :(
// Need to record the range for each layer!!!
public class Solution {
	public boolean isValidBST(TreeNode root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
		
	public boolean checkBST(TreeNode node, int min, int max) {
		if(node == null) return true;
		if(node.val <= min || node.val >= max) return false;
		return ((node.left == null) ? true : checkBST(node.left, min, node.val)) &&
				((node.right == null) ? true : checkBST(node.right, node.val, max));
	}
}

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

public class Solution {
	public boolean isValidBST(TreeNode root) {
		if(root == null) return true;
		if(root.left == null && root.right == null) return true;
		else if(root.left == null) return isValidBST(root.right);
		else if(root.right == null) return isValidBST(root.left);
		else return isValidBST(root.left) && isValidBST(root.right);
	}
}

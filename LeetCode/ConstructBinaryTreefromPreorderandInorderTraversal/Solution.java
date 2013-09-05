/*
 * Construct Binary Tree from Preorder and Inorder Traversal - Sep 30 '12 - 4869 / 14001
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */

package ConstructBinaryTreefromPreorderandInorderTraversal;

import Helper.TreeNode;

// AC on 1st try :)
public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || inorder == null) return null;
		return buildNode(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
	}
	
	public TreeNode buildNode(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
		if(preStart > preEnd || inStart > inEnd) return null;
		TreeNode node = new TreeNode(preorder[preStart]);
		for(int i = 0; i <= inEnd - inStart; i++) {
			if(preorder[preStart] == inorder[i + inStart]) {
				node.left = buildNode(preorder, inorder, preStart + 1, preStart + i, inStart, inStart + i - 1);
				node.right = buildNode(preorder, inorder, preStart + i + 1, preEnd, inStart + i + 1, inEnd);
				break;
			}
		}
		return node;
	}
}

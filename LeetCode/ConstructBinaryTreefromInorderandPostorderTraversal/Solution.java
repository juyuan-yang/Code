/*
 * Construct Binary Tree from Inorder and Postorder Traversal - Sep 30 '12 - 4493 / 12665
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */

package ConstructBinaryTreefromInorderandPostorderTraversal;

import Helper.TreeNode;

// AC on 2nd try, just forgot to add the length == 0 check :(
public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder == null || postorder == null) return null;
		return buildNode(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
	}
	
	public TreeNode buildNode(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
		if(postStart > postEnd || inStart > inEnd) return null; // forgot on 1st try
		TreeNode node = new TreeNode(postorder[postEnd]);
		for(int i = 0; i <= inEnd - inStart; i++) {
			if(inorder[inStart + i] == postorder[postEnd]) {
				node.left = buildNode(inorder, postorder, inStart, inStart + i - 1, postStart, postStart + i - 1);
				node.right = buildNode(inorder, postorder, inStart + i + 1, inEnd, postStart + i, postEnd - 1);
				break;
			}
		}
		return node;
	}
}

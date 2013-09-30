/*
 * Recover Binary Search Tree - Sep 1 '12 - 4967 / 16821
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. 
Could you devise a constant space solution?
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */

package RecoverBinarySearchTree;

import Helper.TreeNode;

// AC on 1st try :)
public class Solution {
	private TreeNode node1, node2, pre;
	
	public void recoverTree(TreeNode root) {
		node1 = null;
		node2 = null;
		pre = null;
		if(root != null) visit(root);
		if(node1 != null && node2 != null) {
			int temp = node1.val;
			node1.val = node2.val;
			node2.val = temp;
		}
	}
	
	public void visit(TreeNode node) {
		if(node.left != null) visit(node.left);
		if(pre != null && node.val < pre.val) {
			if(node1 == null) node1 = pre;
			node2 = node;
		}
		pre = node;
		if(node.right != null) visit(node.right);
	}
}

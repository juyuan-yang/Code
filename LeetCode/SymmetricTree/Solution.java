/*
 * Symmetric Tree - Sep 24 '12 - 7123 / 14917
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */

package SymmetricTree;

import Helper.TreeNode;

// AC on 1st try
public class Solution {
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
		else if(p != null && q != null) {
			return (p.val == q.val) && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
		} else return false;
	}
}

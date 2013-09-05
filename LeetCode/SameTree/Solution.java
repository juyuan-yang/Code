/*
 * Same Tree - Sep 3 '12 - 6423 / 10037
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical 
and the nodes have the same value.
 */

package SameTree;

import Helper.TreeNode;

// AC on 1st try :)
public class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
		else if(p != null && q != null) {
			return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else return false;
	}
}

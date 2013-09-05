/*
 * Binary Tree Level Order Traversal - Sep 29 '12 - 5832 / 14746
Given a binary tree, return the level order traversal of its nodes' values. 
(ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */

package BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;

import Helper.TreeNode;

// AC on 1st try :)
public class Solution {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(root != null) visit(root, 0, res);
		return res;
	}
	
	public void visit(TreeNode node, int depth, ArrayList<ArrayList<Integer>> res) {
		ArrayList<Integer> list;
		if(res.size() <= depth) {
			list = new ArrayList<Integer>();
			res.add(list);
		} else list = res.get(depth);
		list.add(node.val);
		if(node.left != null) visit(node.left, depth+1, res);
		if(node.right != null) visit(node.right, depth+1, res);
	}
}

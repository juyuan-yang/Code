/*
 * Binary Tree Zigzag Level Order Traversal - Sep 29 '12 - 4378 / 12129
Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */

package BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;

import Helper.TreeNode;

public class Solution {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(root != null) visit(root, 0, res);
		return res;
	}

	public visit(TreeNode node, int depth, ArrayList<ArrayList<Integer>> res) {
		ArrayList<Integer> list;
		if(depth >= res.size()) {
			list = new ArrayList<Integer>();
			res.add(list);
		} else list = res.get(depth);
		list.add(node.val);
		if(node.left != null) visit(node.left, depth+1, res);
		if(node.right != null) visit(node.right, depth+1, res);
	}
}

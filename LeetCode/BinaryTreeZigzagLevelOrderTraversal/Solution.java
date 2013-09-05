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

// AC on 2nd try :( forgot the zigzag thing......
public class Solution {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(root != null) visit(root, 0, res);
		for(int i = 1; i < res.size(); i += 2) {
			ArrayList<Integer> list = res.get(i);
			for(int j = 0; j < list.size() / 2; j++) {
				int temp = list.get(j);
				list.set(j, list.get(list.size()-1-j));
				list.set(list.size()-1-j, temp);
			}
		}
		return res;
	}

	public void visit(TreeNode node, int depth, ArrayList<ArrayList<Integer>> res) {
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

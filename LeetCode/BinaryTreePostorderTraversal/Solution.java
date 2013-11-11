/*
 * Binary Tree Postorder Traversal - Total Accepted: 1312 Total Submissions: 4139 My Submissions
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 */

package BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.Stack;

import Helper.TreeNode;

// AC on 1st try :)
public class Solution {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		Stack<Boolean> expands = new Stack<Boolean>();
		if(root != null) {
			nodes.add(root);
			expands.add(false);
		}
		while(!nodes.isEmpty()) {
			boolean expand = expands.pop();
			TreeNode node = nodes.pop();
			if(expand) {
				list.add(node.val);
			} else {
				nodes.add(node);
				expands.add(true);
				if(node.right != null) {
					nodes.add(node.right);
					expands.add(false);
				}
				if(node.left != null) {
					nodes.add(node.left);
					expands.add(false);
				}
			}
		}
		return list;
	}
}

/*
 * Binary Tree Inorder Traversal - Aug 27 '12 - 7385 / 16684
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */

package BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import Helper.TreeNode;

public class Solution {
	// Iterative version AC on 2nd try :( get stuck in the map part in 1st try, which is silly :(
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Map<TreeNode, Boolean> map = new HashMap<TreeNode, Boolean>();
		stack.add(root);
		
		while(stack.size() > 0) {
			TreeNode node = stack.pop();
			if(!map.containsKey(node)) { // expand
				map.put(node, false);
				if(node.right != null) stack.add(node.right);
				stack.add(node);
				if(node.left != null) stack.add(node.left);
			} else if(!map.get(node)){ // output
				map.put(node, true);
				list.add(node.val);
			}
		}
		return list;
	}
	
	// Recursive solution, AC on 1st try
	public ArrayList<Integer> inorderTraversal_rec(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		visit(root, list);
		return list;
	}
	
	public void visit(TreeNode node, ArrayList<Integer> list) {
		if(node == null) return;
		visit(node.left, list);
		list.add(node.val);
		visit(node.right, list);
	}
}

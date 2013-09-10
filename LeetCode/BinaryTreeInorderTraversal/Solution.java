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
	// iterative version is still a shit now :(
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
		stack.add(root);
		map.put(root, 0);
		
		while(stack.size() > 0) {
			TreeNode node = stack.pop();
			addNode(node.right, map, stack, list);
			addNode(node, map, stack, list);
			addNode(node.left, map, stack, list);
		}
		return list;
	}
	
	public void addNode(TreeNode node, Map<TreeNode, Integer> map,
				Stack<TreeNode> stack, ArrayList<Integer> list) {
		if(node != null) {
			if(!map.containsKey(node)) {
				map.put(node, 0);
				stack.add(node);
			} else {
				int value = map.get(node);
				if(value == 0){
					map.put(node, 1);
					stack.add(node);
				} else if(value == 1){
					list.add(node.val);
					map.put(node, 2);
				}
			}
		}
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

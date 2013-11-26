/*
 * Binary Tree Level Order Traversal II - Oct 1 '12 -4449 / 10092
Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:

[
  [15,7]
  [9,20],
  [3],
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */

package BinaryTreeLevelOrderTraversal2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import Helper.TreeNode;

public class Solution {
	// Iterative version
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(root);
        
        while(!nodes.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(TreeNode node : nodes) {
                list.add(node.val);
            }
            res.add(list);
            
            ArrayList<TreeNode> newNodes = new ArrayList<TreeNode>();
            for(TreeNode node : nodes) {
                if(node.left != null) newNodes.add(node.left);
                if(node.right != null) newNodes.add(node.right);
            }
            
            nodes = newNodes;
        }
        
        Collections.reverse(res);
        return res;
    }
	
 // AC on 3rd try :(
 // Made a silly mistake, need to pay attention the order of putting ArrayList into final result
//	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
//		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
//		visit(root, 0, map);
//		for(int i = 0; i < map.size(); i++) {
//			res.add(map.get(map.size() - 1 - i));
//		}
//		return res;
//	}
//	
//	public void visit(TreeNode node, int height, Map<Integer, ArrayList<Integer>> map) {
//		if(node == null) return;
//		visit(node.left, height+1, map);
//		visit(node.right, height+1, map);
//		ArrayList<Integer> list = map.containsKey(height) ? (map.get(height)) : new ArrayList<Integer>();
//		list.add(node.val);
//		map.put(height, list);
//	}
}

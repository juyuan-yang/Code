/*
 * Path Sum II - Oct 14 '12 - 6392 / 17591
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]
 */

package PathSum2;

import java.util.ArrayList;

import Helper.TreeNode;

public class Solution {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		visit(root, 0, sum, new ArrayList<Integer>(), res);
		return res;
	}
	
	public void visit(TreeNode node, int currentSum, int sum, ArrayList<Integer> list,
			ArrayList<ArrayList<Integer>> res) {
		if(node == null) return;
		currentSum += node.val;
		list.add(node.val);
		if(node.left == null && node.right == null) {
			if(currentSum == sum) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.addAll(list);
				res.add(temp);
			}
		} else {
			if(node.left != null) visit(node.left, currentSum, sum, list, res);
			if(node.right != null) visit(node.right, currentSum, sum, list, res);
		}
		list.remove(list.size() - 1);
	}
}

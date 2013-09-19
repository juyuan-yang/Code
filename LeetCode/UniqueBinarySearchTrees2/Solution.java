/*
 * Unique Binary Search Trees II - Aug 27 '12 - 3664 / 10952
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

package UniqueBinarySearchTrees2;

import java.util.ArrayList;

import Helper.TreeNode;

// AC on 3rd try :( need to be careful when start > end......
// Anyway, I think current code is so short :)
public class Solution {
	public ArrayList<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}
	
	public ArrayList<TreeNode> generateTrees(int start, int end) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		if(start > end) {
			list.add(null);
			return list;
		} else if(start == end) {
			TreeNode node = new TreeNode(start);
			list.add(node);
			return list;
		}
		for(int i = start; i <= end; i++) {
			ArrayList<TreeNode> lefts = generateTrees(start, i-1);
			ArrayList<TreeNode> rights = generateTrees(i+1, end);
			
			for(TreeNode left : lefts) {
				for(TreeNode right : rights) {
					TreeNode node = new TreeNode(i);
					node.left = left;
					node.right = right;
					list.add(node);
				}
			}
		}
		return list;
	}
}

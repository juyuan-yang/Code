/*
 * Sum Root to Leaf Numbers - Feb 19 - 8344 / 23632

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3

The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 */

package SumRoottoLeafNumbers;

import Helper.TreeNode;

// what a shame, AC on 2nd try!!!
public class Solution {
	int res;
	public int sumNumbers(TreeNode root) {
		if(root == null) return 0;
		res = 0;
		tryEachNode(root, 0);
		return res;
	}
	
	public void tryEachNode(TreeNode node, int num) {
		num = num * 10 + node.val;
		if(node.left == null && node.right == null) {
			res += num;
		} else {
			if(node.left != null) {
				tryEachNode(node.left, num);
			}
			if(node.right != null) {
				tryEachNode(node.right, num);
			}
		}
	}
}

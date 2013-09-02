/*
 * Path Sum - Oct 14 '12 - 6653 / 15901
Given a binary tree and a sum, 
determine if the tree has a root-to-leaf path such that adding up all the values along the path 
equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

package PathSum;

import Helper.TreeNode;

// the code is really short! :) but AC on 2nd try :(
// when root is null, should return false...
public class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		if(root.left == null && root.right == null) return sum == root.val; // I wrote sum == 0 in 1st try :(
		if(root.left != null && hasPathSum(root.left, sum - root.val)) return true;
		else return root.right != null && hasPathSum(root.right, sum - root.val);
	}
}

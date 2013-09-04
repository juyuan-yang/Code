/*
 * Populating Next Right Pointers in Each Node II - Oct 28 '12 - 5299 / 13177
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,

         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */

package PopulatingNextRightPointersinEachNode2;

import Helper.TreeLinkNode;

// AC on 1st try. I almost remember the solution
public class Solution {
	public void connect(TreeLinkNode root) {
		TreeLinkNode cur = root;
		while(cur != null) {
			TreeLinkNode nextStart = null, prev = null;
			for( ; cur != null; cur = cur.next) {
				if(nextStart == null) 
					nextStart = (cur.left != null) ? cur.left : cur.right;
				
				if(cur.left != null) {
					if(prev != null) prev.next = cur.left;
					prev = cur.left;
				}
				
				if(cur.right != null) {
					if(prev != null) prev.next = cur.right;
					prev = cur.right;
				}
			}
			cur = nextStart;
		}
	}
}

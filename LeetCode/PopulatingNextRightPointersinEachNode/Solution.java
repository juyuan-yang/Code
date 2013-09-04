/*
 * Populating Next Right Pointers in Each Node - Oct 28 '12 - 5938 / 12053
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, 
the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, 
and every parent has two children).
For example,
Given the following perfect binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */

package PopulatingNextRightPointersinEachNode;

import Helper.TreeLinkNode;

// AC on 2nd try, need to pay attention about cur and prev, and right way to assign next
public class Solution {
	public void connect(TreeLinkNode root) {
		TreeLinkNode cur = root;
		while(cur != null) {
			TreeLinkNode nextStart = null, prev = null;
			
			for( ; cur != null; cur = cur.next) {
				if(nextStart == null) {
					nextStart = (cur.left != null) ? cur.left : cur.right;
				}

				if(cur.left != null) {
					cur.left.next = cur.right;
					if(prev != null) {
						prev.right.next = cur.left;
					}
				}
				
				prev = cur;
			}
			
			cur = nextStart;
		}
	}
}

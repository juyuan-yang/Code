/*
 * Convert Sorted List to Binary Search Tree - Oct 3 '12 - 5768 / 16298
Given a singly linked list where elements are sorted in ascending order, 
convert it to a height balanced BST.
 */

package ConvertSortedListtoBinarySearchTree;

import Helper.ListNode;
import Helper.TreeNode;

// AC on 2nd try :(
public class Solution {
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) return null;
		int length = 0;
		for(ListNode node = head; node != null; node = node.next) length++;
		return buildTree(head, 0, length - 1);
	}
	
	public TreeNode buildTree(ListNode head, int start, int end) {
		if(start > end || head == null) return null;
		int mid = (start + end) / 2;
		TreeNode left = buildTree(head, start, mid-1);
		TreeNode node = new TreeNode(head.val);
		node.left = left;
		if(head.next != null) {
			head.val = head.next.val;
			head.next = head.next.next;
			node.right = buildTree(head, mid+1, end); // bug here on 1st try
			// really don't like this way, I need &head in C! >.<
		} else {
			node.right = null;
		}
		return node;
	}
	
	// A little simplified version
//    public TreeNode sortedListToBST(ListNode head) {
//        int len = 0;
//        for(ListNode tmp = head; tmp != null; tmp = tmp.next, len++);
//        return traverse(head, 0, len - 1);
//    }
//    
//    public TreeNode traverse(ListNode head, int start, int end) {
//        if(start > end) return null;
//        int mid = (end - start) / 2 + start;
//        TreeNode left = traverse(head, start, mid - 1);
//        TreeNode node = new TreeNode(head.val);
//        node.left = left;
//        if(head.next != null) {
//            head.val = head.next.val;
//            head.next = head.next.next;
//            node.right = traverse(head, mid + 1, end);
//        }
//        return node;
//    }
}

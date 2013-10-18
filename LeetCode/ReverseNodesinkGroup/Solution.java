/*
 * Reverse Nodes in k-Group - AC Rate: 705/3203 My Submissions
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */

package ReverseNodesinkGroup;

import Helper.ListNode;

// AC on 2nd try :( missing one statement in 1st try
public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(k == 1) return head;
		ListNode preEnd = null, start = head, nextStart = null, cur = head;
		int has = 0;
		while(cur != null) {
			has++;
			if(has == k) {
				nextStart = cur.next;
				reverse(start, cur);
				if(preEnd == null) head = cur;
				else preEnd.next = cur;
				preEnd = start;
				start.next = nextStart;
				
				has = 0;
				start = nextStart;
				cur = start; // bug, forgot in 1st try
			} else cur = cur.next;
		}
		return head;
	}
	
	public void reverse(ListNode start, ListNode end) {
		ListNode pre = null, cur = start, next;
		while(cur != end) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		cur.next = pre;
	}
}

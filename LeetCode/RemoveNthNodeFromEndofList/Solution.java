/*
 * Remove Nth Node From End of List - AC Rate: 1494/5019 My Submissions
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */

package RemoveNthNodeFromEndofList;

import Helper.ListNode;

// AC on 1st try :)
public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p1 = head, p2 = head;
		for(int i = 0; i < n; i++) p1 = p1.next;
		if(p1 == null) {
			return head.next;
		} else {
			while(p1.next != null) {
				p1 = p1.next;
				p2 = p2.next;
			}
			p2.next = p2.next.next;
			return head;
		}
	}
}

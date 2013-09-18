/*
 * Remove Duplicates from Sorted List II - Apr 22 '12 - 5564 / 16823
Given a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */

package RemoveDuplicatesfromSortedList2;

import Helper.ListNode;

// AC on 5th try :( Really need to be very careful about pointers... 
// Should re-do this at the beginning of the 3rd round
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head, pre = null;
		while(cur != null) {
			boolean delete = false;
			while(cur.next != null) {
				if(cur.val == cur.next.val) {
					cur.next = cur.next.next;
					delete = true;
				} else break;
			}
			if(delete) {
				if(pre != null) pre.next = cur.next;	
				if(head == cur) head = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}
}

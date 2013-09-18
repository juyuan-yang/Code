/*
 * Remove Duplicates from Sorted List - Apr 22 '12 - 6081 / 11943
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */

package RemoveDuplicatesfromSortedList;

import Helper.ListNode;

// AC on 2nd try :( forgot the continue statement :(
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		while(cur != null) {
			if(cur.next != null) {
				if(cur.val == cur.next.val) {
					cur.next = cur.next.next;
					continue;
				}
			}
			cur = cur.next;
		}
		return head;
	}
}

/*
 * Reverse Linked List II - Jun 27 '12 - 5508 / 18773
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ? m ? n ? length of list.
 */

package ReverseLinkedList2;

import Helper.ListNode;

// AC on 3rd try :( forgot count++!!!!!!!!
public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode origEnd = null, begin, cur = head, pre = null, next;
		int count = 1;
		while(cur != null && count < m) {
			origEnd = cur;
			cur = cur.next;
			count ++; // forgot :(
		}
		begin = cur;
		
		while(cur != null && count <= n) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
			count++; // forgot :(
		}
		
		begin.next = cur;
		if(origEnd == null) return pre;
		origEnd.next = pre;
		return head;
	}
}

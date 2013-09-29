/*
 * Merge Two Sorted Lists - AC Rate: 625/1829 - My Submissions
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.
 */

package MergeTwoSortedLists;

import Helper.ListNode;

// AC on 3rd try :( I'm stupid at the beginning...
public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null, cur = null;
		
		if(l1 == null) return l2;
		else if(l2 == null) return l1;
		
		while(l1 != null && l2 != null){
			if(l1.val <= l2.val) {
				if(head == null) head = l1;
	        	if(cur != null) cur.next = l1;
	        	cur = l1;
				l1 = l1.next;
			} else {
				if(head == null) head = l2;
	        	if(cur != null) cur.next = l2;
	        	cur = l2;
				l2 = l2.next;
			}
		}
		
		if(l1 != null) cur.next = l1;
		else cur.next = l2;
		
		return head;
	}
}

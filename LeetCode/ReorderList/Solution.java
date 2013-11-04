/*
 * Reorder List - Total Accepted: 408 Total Submissions: 2420 My Submissions
Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */

package ReorderList;

import Helper.ListNode;

public class Solution {
	// AC on 1st try on this solution... too complex in previous try...
	// cleaner code?
	public void reorderList(ListNode head) {
	    if(head == null) return;
	    
		int len = 0;
		for(ListNode tmp = head; tmp != null; tmp = tmp.next, len++) ;
	    if(len < 3) return;
	    
	    ListNode start = head;
	    for(int i = 0; i < (len + 1) / 2; i++, start = start.next) ;
	    
	    ListNode pre = null, next = null, cur = start;
	    while(cur != null) {
	        next = cur.next;
	        cur.next = pre;
	        pre = cur;
	        cur = next;
	    }
	    
	    cur = head;
	    while(pre != null) {
	        next = cur.next;
	        cur.next = pre;
	        pre = pre.next;
	        cur.next.next = next;
	        cur = next;
	    }
	    cur.next = null;
	}
}

/*
 * Insertion Sort List - Total Accepted: 1283 Total Submissions: 5144 My Submissions
Sort a linked list using insertion sort.
 */

package InsertionSortList;

import Helper.ListNode;

public class Solution {
	public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode cur = head.next, pre = head, p, q, next, nextPre = null;
        
        while(cur != null) {
            next = cur.next;
            p = null;
            q = head;
            while(cur.val > q.val) {
                p = q;
                q = q.next;
            }
            if(p == null) {
                pre.next = cur.next;
                cur.next = head;
                head = cur;
                nextPre = pre;
            } else if(cur != q) {
                pre.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                nextPre = pre;
            } else {
                nextPre = cur;
            }
            pre = nextPre;
            cur = next;
        }
        return head;
    }
}

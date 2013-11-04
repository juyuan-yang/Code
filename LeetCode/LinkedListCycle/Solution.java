/*
 * Linked List Cycle - Total Accepted: 2077 Total Submissions: 5593 My Submissions
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 */

package LinkedListCycle;

import Helper.ListNode;

// AC on 1st try
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        while(p1 != null && p2 != null) {
            p1 = p1.next;
            if(p2.next != null) p2 = p2.next.next;
            else return false;
            if(p1 == p2) return true;
        }
        return false;
    }
}

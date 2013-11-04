/*
 * Linked List Cycle II - Total Accepted: 1095 Total Submissions: 3777 My Submissions
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?
 */

package LinkedListCycle2;

import Helper.ListNode;

// AC on 3rd try. The important thing is the right solution
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        while(p1 != null && p2 != null) {
            p1 = p1.next;
            if(p2.next != null) p2 = p2.next.next;
            else return null;
            if(p1 == p2) {
                break;
            }
        }
        if(p1 == null || p2 == null) return null; // bug, need to check here
        p1 = head;
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}

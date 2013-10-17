/*
 * Rotate List - AC Rate: 425/1907 My Submissions
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */

package RotateList;

import Helper.ListNode;

// AC on 1st try :)
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null) return null;
        int len = 1;
        ListNode temp = head, tail = head;
        for( ; tail.next != null; tail = tail.next) len++;
        
        n %= len;
        if(n == 0) return head;
        n = len - n;
        
        for(int l = 1; l < n; l++) temp = temp.next;
        
        tail.next = head;
        head = temp.next;
        temp.next = null;
        return head;
    }
}

/*
 * Swap Nodes in Pairs - AC Rate: 1496/4625 My Submissions
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. 
You may not modify the values in the list, only nodes itself can be changed.
 */

package SwapNodesinPairs;

import Helper.ListNode;

// AC on 1st try :)
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode preEnd = null, cur = head, start = null, nextStart = null;
        
        while(cur != null) {
            if(start == null) {
                start = cur;
                cur = cur.next;
            } else {
                nextStart = cur.next;
                cur.next = start;
                start.next = nextStart;
                if(preEnd == null) head = cur;
                else preEnd.next = cur;
                preEnd = start;
                cur = nextStart;
                
                start = null;
            }
        }
        return head;
    }
}

/*
 * Add Two Numbers - AC Rate: 1573/6966 My Submissions
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */

package AddTwoNumbers;

import Helper.ListNode;

// AC on 2nd try :( forgot to check the carry finally
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null, cur = null;
		
		int carry = 0, val;
		while(l1 != null || l2 != null) {
			val = carry;
			if(l1 != null) {
				val += l1.val;
				l1 = l1.next;
			}
			if(l2 != null) {
				val += l2.val;
				l2 = l2.next;
			}
			
			ListNode temp = new ListNode(val % 10);
			carry = val / 10;
			if(cur != null) cur.next = temp;
			cur = temp;
			if(head == null) head = temp;
		}
		
		if(carry == 1) {
			ListNode temp = new ListNode(1);
			cur.next = temp;
		}
		return head;
	}
	
	// these codes are for reversed way to store numbers
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int len1 = 0, len2 = 0;
//        
//        for(ListNode temp = l1; temp != null; temp = temp.next) len1++;
//        for(ListNode temp = l2; temp != null; temp = temp.next) len2++;
//        
//        if(len1 == 0 && len2 == 0) {
//            return new ListNode(0);
//        } else if(len1 == 0) {
//            return l2;
//        } else if(len2 == 0) {
//            return l1;
//        }
//        ListNode head = addTwoNumbers(l1, l2, len1, len2);
//        while(head.val > 9) {
//            ListNode pre = new ListNode(head.val / 10);
//            head.val %= 10;
//            pre.next = head;
//            head = pre;
//        }
//        return head;
//    }
//    
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int len1, int len2) {
//        if(len1 == 1 && len2 == 1) return new ListNode(l1.val + l2.val);
//        ListNode pre, node;
//        if(len1 < len2) {
//            pre = addTwoNumbers(l1, l2.next, len1, len2-1);
//            node = new ListNode(l2.val + pre.val / 10);
//        } else if(len2 < len1) {
//            pre = addTwoNumbers(l1.next, l2, len1-1, len2);
//            node = new ListNode(l1.val + pre.val / 10);
//        } else {
//            pre = addTwoNumbers(l1.next, l2.next, len1-1, len2-1);
//            node = new ListNode(l1.val + l2.val + pre.val / 10);
//        }
//        pre.val %= 10;
//        node.next = pre;
//        return node;
//    }
}

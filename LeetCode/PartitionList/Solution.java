/*
 * Partition List - Apr 30 '12 - 5164 / 15877
Given a linked list and a value x, partition it such that all nodes less than x come 
before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */

package PartitionList;

import Helper.ListNode;

public class Solution {
	// AC on 1st try :) 0.0 But I may need to rewrite it
	public ListNode partition(ListNode head, int x) {
		ListNode cur = head, pre = null;
		
		while(cur != null && cur.val < x) {
			pre = cur;
			cur = cur.next;
		}
		if(cur == null) return head;
		
		while(true) {
			ListNode preSmall = pre, preBig = null, temp;
			pre = null;
			while(cur != null && cur.val >= x) {
				pre = cur;
				cur = cur.next;
			}
			if(cur == null) return head;
			preBig = pre;
			pre = null;
			while(cur != null && cur.val < x) {
				pre = cur;
				cur = cur.next;
			}
			temp = preBig.next;
			if(preSmall == null) {
				preBig.next = cur;
				pre.next = head;
				head = temp;
			} else {
				preBig.next = cur;
				pre.next = preSmall.next;
				preSmall.next = temp;
			}
		}
	}
	
	// TLE!!!! what the ****!!!
//	public ListNode partition(ListNode head, int x) {
//		if(head == null) return null;
//		ListNode big = null, cur = head, bigStart = null;
//		while(true) {
//			if(cur.val >= x) {
//				if(bigStart == null) bigStart = cur;
//				if(big != null) big.next = cur;
//				big = cur;
//				if(cur == head) head = head.next;
//			}
//			if(cur.next == null) break;
//			cur = cur.next;
//		}
//		if(bigStart != null && cur != null) cur.next = bigStart;
//		return head;
//	}
}

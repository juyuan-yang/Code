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

// TLE!!!! what the ****!!!
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(1);
		n2.next = n1;
		System.out.println(s.partition(n2, 2).val);
	}
	
	public ListNode partition(ListNode head, int x) {
		if(head == null) return null;
		ListNode big = null, cur = head, bigStart = null, smallStart = null, small = null;
		while(cur != null) {
			if(cur.val < x) {
				if(smallStart == null) smallStart = cur;
				if(small != null) small.next = cur;
				small = cur;
			} else {
				if(bigStart == null) bigStart = cur;
				if(big != null) big.next = cur;
				big = cur;
			}
			cur = cur.next;
		}
		if(bigStart != null && small != null) small.next = bigStart;
		return smallStart;
	}
}

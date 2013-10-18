/*
 * Merge k Sorted Lists - AC Rate: 1193/5342 My Submissions
Merge k sorted linked lists and return it as one sorted list. 
Analyze and describe its complexity.
 */

package MergekSortedLists;

import java.util.ArrayList;

import Helper.ListNode;

// AC on 1st try :)
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;
        for(int k = 1; k < lists.size(); k = k * 2) {
            for(int i = 0; i + k < lists.size(); i = i + k * 2) {
                lists.set(i, merge(lists.get(i), lists.get(i+k)));
            }
        }
        return lists.get(0);
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = null, cur = null, temp;
        while(l1 != null || l2 != null) {
        	if(l2 == null || (l1 != null && l2 != null && l1.val < l2.val)) {
        		temp = l1;
                l1 = l1.next;
        	} else {
        		temp = l2;
                l2 = l2.next;
        	}
            if(head == null) head = temp;
            if(cur != null) cur.next = temp;
            cur = temp;
        }
        return head;
    }
}

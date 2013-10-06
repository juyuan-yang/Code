/*
 * Copy List with Random Pointer - AC Rate: 440/2007 - My Submissions
A linked list is given such that each node contains an additional random pointer 
which could point to any node in the list or null.

Return a deep copy of the list.
 */

package CopyListwithRandomPointer;

import java.util.HashMap;
import java.util.Map;

import Helper.RandomListNode;

// AC on 1st try :)
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) return null;
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode newHead = new RandomListNode(head.label);
		RandomListNode cur = head, newCur = newHead, newRandom = null, newNext = null;
		map.put(head, newHead);
		
		while(cur != null) {
			if(cur.random != null) {
				if(map.containsKey(cur.random)) newRandom = map.get(cur.random);
				else {
					newRandom = new RandomListNode(cur.random.label);
					map.put(cur.random, newRandom);
				}
				newCur.random = newRandom;
			}
			if(cur.next != null) {
				if(map.containsKey(cur.next)) newNext = map.get(cur.next);
				else {
					newNext = new RandomListNode(cur.next.label);
					map.put(cur.next, newNext);
				}
				newCur.next = newNext;
			}
			newCur = newCur.next;
			cur = cur.next;
		}
		
		return newHead;
	}
}

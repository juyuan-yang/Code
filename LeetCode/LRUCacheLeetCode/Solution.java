/*
 * LRU Cache - Total Accepted: 310 Total Submissions: 2776 My Submissions
Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key 
if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item 
before inserting a new item.
 */

package LRUCacheLeetCode;

// AC on 3rd try :(
public class Solution {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(1, 1);
		get(cache, 2);
		cache.set(4, 1);
		get(cache, 1);
		get(cache, 2);
	}
	
	private static void get(LRUCache cache, int key) {
		System.out.println(cache.get(key));
	}
}

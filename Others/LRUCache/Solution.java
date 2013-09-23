/*
 * https://box.interviewstreet.com/challenges/dashboard/#problem/4f3c42a47d165
 * 
 * LRU Cache

Caches are a key element in scaling a system. One popular form of cache is called a Least Recently Used Cache 
(http://en.wikipedia.org/wiki/Cache_algorithms#Least_Recently_Used). 
Your task is to implement a cache that can be tested against a series of inputs. 
These actions should define an API you use for the cache object.

Your cache should store simple key/value strings of length up to 10 characters. 
It should also have a customizable upper bound to the number of keys that can be stored in the cache 
at any time. You do not have to be thread safe.

Possible Inputs:

BOUND    :  Set the upper bound. If the cache size is currently greater than this number, 
then extra entries must be removed following the LRU policy
SET   :  Set the value of this key
GET   :  Get the value of this key and prints to stdout.
PEEK   :  Gets the value of the key but does not mark it as being used. Prints the value to standard out.
DUMP  :  Prints the current state of the cache as a list of key/value pairs in alphabetical order by key.

Input Format:
First line of input contains an integer N,the number of commands.
The following N lines each describe a command.
Note: The first command will always be BOUND.

Output Format:
Print the appropriate outputs for GET , PEEK and DUMP commands. 
In case for GET/PEEK command if the key does not exist in the cache just output the string "NULL"
(quotes are for clarity).

Sample Input

8
BOUND 2
SET a 2
SET b 4
GET b
PEEK a
SET c 5
GET a
DUMP

Sample Output

4
2
NULL
b 4
c 5

Constraints:
Total number of lines in input will be no more than 1,000,000(10^6)
Note: There may be DUMP commands scattered throughout the input file.
 */
/*
 Enter your code here. Read input from STDIN. Print output to STDOUT
 Your class should be named Solution
*/

package LRUCache;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) {
		try{
			Solution s = new Solution();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String temp = br.readLine();
			int N = Integer.parseInt(temp.trim());
			for(int i = 0; i < N; i++) {
				temp = br.readLine().trim();
				s.cmdParser(temp);
			}
			br.close();
		} catch (Exception e) {
			
		}
	}
	
	void cmdParser(String temp) {
		switch(temp.charAt(0)) {
		case 'B': // BOUND 2
			int bound = Integer.parseInt(temp.split(" ")[1]);
			setBound(bound);
			break;
		case 'S': // SET c 5
			String[] strs = temp.split(" ");
			setVal(strs[1], Integer.parseInt(strs[2]));
			break;
		case 'G': // GET b
			getVal(temp.split(" ")[1]);
			break;
		case 'P': // PEEK a
			peek(temp.split(" ")[1]);
			break;
		case 'D': // DUMP
			dump();
			break;
		}
	}
	
	LinkedList head = null, tail = null;
	Map<String, LinkedList> key2node = new HashMap<String, LinkedList>();
	int length = 0, bound = -1;
	
	void setBound(int bound) {
		if(this.bound == -1) this.bound = bound;
		else {
			if(bound >= length) this.bound = bound;
			else {
				int toDelete = length - bound;
				while(toDelete > 0) {
					toDelete--;
					key2node.remove(tail.key);
					tail = tail.father;
				}
			}
		}
	}
	
	/*
	 * Set value for one key
	 * If the key already exists, then update it, also its father & son
	 * Otherwise, if still has space, just add it, or remove the tail
	 * 
	 * Finally, make this node to head. If tail is null, also make this node tail
	 */
	void setVal(String key, int val) {
		LinkedList node;
		if(key2node.containsKey(key)) {
			node = key2node.get(key);
			node.data = val;
			LinkedList father = node.father, son = node.son;
			if(father != null) father.son = son;
			if(son != null) son.father = father;
		} else {
			node = new LinkedList(val, key);
			if(length < bound) {
				length++;
			} else if(tail != null) {
				key2node.remove(tail.key);
				tail = tail.father;
			}
			key2node.put(key, node);
		}
		node.son = head;
		node.father = null;
		head = node;
		if(tail == null) tail = node;
	}
	
	// output the val, or NULL
	void getVal(String key) {
		if(key2node.containsKey(key)) {
			LinkedList node = key2node.get(key);
			printVal(node.data);
			LinkedList father = node.father, son = node.son;
			if(father != null) father.son = son;
			if(son != null) son.father = father;
			
			node.son = head;
			node.father = null;
			head = node;
		} else {
			printNull();
		}
	}
	
	// output the val, or NULL
	void peek(String key) {
		if(head != null) {
			LinkedList node = key2node.get(key);
			printVal(node.data);
		} else {
			printNull();
		}
	}
	
	// Prints the current state of the cache as a list of key/value pairs in alphabetical order by key.
	void dump() {
		ArrayList<LinkedList> list = new ArrayList<LinkedList>();
		list.addAll(key2node.values());
		Collections.sort(list);
		for(LinkedList node : list) {
			printKeyVal(node.key, node.data);
		}
	}
	
	class LinkedList implements Comparable<LinkedList>{
		LinkedList father, son;
		int data;
		String key;
		
		public LinkedList(int val, String key) {
			this.key = key;
			father = null;
			son = null;
			data = val;
		}

		@Override
		public int compareTo(LinkedList arg) {
			return key.compareTo(arg.key);
		}
	}
	
	void printVal(int val) {
		System.out.println(val);
	}
	
	void printNull() {
		System.out.println("NULL");
	}
	
	void printKeyVal(String key, int val) {
		System.out.println(key + " " + val);
	}
}

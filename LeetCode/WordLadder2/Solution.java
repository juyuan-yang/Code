/*
 * Word Ladder II - Feb 11 - 7646 / 36433
Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

Return

  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:

All words have the same length.
All words contain only lowercase alphabetic characters.
 */

package WordLadder2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// temp version :(
public class Solution {
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if(start == null || end == null || dict.size() == 0) return res;
		dict.add(start);
		dict.add(end);
		
		Map<String, Boolean> visited = new HashMap<String, Boolean>();
		for(String str : dict) visited.put(str, false);
		Map<String, String> parent = new HashMap<String, String>();
		Set<String> toVisit = new HashSet<String>();
		boolean found = false;
		
		toVisit.add(start);
		parent.put(start, "");
		while(toVisit.size() > 0) {
			Set<String> newSet = new HashSet<String>();
			for(String str : toVisit) {
				if(str.equals(end)) {
					found = true;
				}
				visited.put(str, true);
				newSet.addAll(findNextStrs(str, visited, parent, dict, end));
			}
			if(found) return res;
			toVisit = newSet;
		}
		
		return res;
	}
	
	public ArrayList<String> findNextStrs(String word, Map<String, Boolean> visited, 
				Map<String, String> parent, HashSet<String> dict, String end) {
		ArrayList<String> res = new ArrayList<String>();
		char[] str = word.toCharArray();
		for(int i = 0; i < str.length; i++) {
			char ch = str[i];
			for(char newCh = 'a'; newCh <= 'z'; newCh++) {
				if(newCh != ch) {
					str[i] = newCh;
					String temp = new String(str);
					if(temp.equals(end) || (dict.contains(temp) && !visited.get(temp))) {
						res.add(temp);
						parent.put(temp, word);
					}
				}
			}
			str[i] = ch;
		}
		return res;
	}
}
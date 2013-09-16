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
import java.util.List;
import java.util.Map;
import java.util.Set;

// Time Limit Exceed :(
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		HashSet<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		for(ArrayList<String> list : s.findLadders("a", "c", set)) {
			for(String str : list) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if(start == null || end == null || dict.size() == 0) return res;
		dict.add(start);
		dict.add(end);
		
		Map<String, Boolean> visited = new HashMap<String, Boolean>();
		for(String str : dict) visited.put(str, false);
		Map<String, List<String>> parents = new HashMap<String, List<String>>();
		Set<String> toVisit = new HashSet<String>();
		int step = 1;
		
		toVisit.add(start);
		parents.put(start, new ArrayList<String>());
		while(toVisit.size() > 0) {
			Set<String> newSet = new HashSet<String>();
			for(String str : toVisit) {
				if(str.equals(end)) {
					findAllRes(parents, res, step, 0, start, end, new String[step]);
					return res;
				}
				visited.put(str, true);
				newSet.addAll(findNextStrs(str, visited, parents, dict, end));
			}
			toVisit = newSet;
			step++;
		}
		return res;
	}
	
	public void findAllRes(Map<String, List<String>> parents, ArrayList<ArrayList<String>> res, 
			int step, int curStep, String start, String curWord, String[] words) {
		if(curStep == step) {
			if(!curWord.equals(start)) return;
			ArrayList<String> list = new ArrayList<String>();
			for(int i = step-1; i >= 0; i--) list.add(words[i]);
			res.add(list);
			return;
		} else if(curStep == 0) {
			words[0] = curWord;
			findAllRes(parents, res, step, curStep+1, start, curWord, words);
			return;
		}
		for(String next : parents.get(curWord)) {
			words[curStep] = next;
			findAllRes(parents, res, step, curStep+1, start, next, words);
		}
	}
	
	public ArrayList<String> findNextStrs(String word, Map<String, Boolean> visited, 
				Map<String, List<String>> parents, HashSet<String> dict, String end) {
		ArrayList<String> res = new ArrayList<String>();
		char[] str = word.toCharArray();
		for(int i = 0; i < str.length; i++) {
			char ch = str[i];
			for(char newCh = 'a'; newCh <= 'z'; newCh++) {
				if(newCh != ch) {
					str[i] = newCh;
					String temp = new String(str);
					// as the end word could be reached from several words
					if(temp.equals(end) || (dict.contains(temp) && !visited.get(temp))) {
						res.add(temp);
						if(parents.get(temp) == null) {
							ArrayList<String> list = new ArrayList<String>();
							list.add(word);
							parents.put(temp, list);
						} else {
							parents.get(temp).add(word);
						}
					}
				}
			}
			str[i] = ch;
		}
		return res;
	}
}
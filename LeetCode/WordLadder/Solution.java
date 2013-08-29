/*
 * Word Ladder - Feb 11 - 10499 / 37276
Given two words (start and end), and a dictionary, 
find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 */

package WordLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

// did a stupid solution at first, don't need to try the same word twice!
// AC on the 1st try of the new code :)
public class Solution {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		if(start == null || end == null) return 0;
		dict.add(start);
		dict.add(end);
		
		int res = 1;
		Map<String, Boolean> visited = new HashMap<String, Boolean>();
		for(String word : dict) {
			visited.put(word, false);
		}
		HashSet<String> oneIter = new HashSet<String>();
		oneIter.add(start);
		
		while(!oneIter.isEmpty() && !oneIter.contains(end)) {
			HashSet<String> nextIter = new HashSet<String>();
			res++;
			for(String word : oneIter) {
				nextIter.addAll(generateList(word.toCharArray(), visited, dict));
			}
			oneIter = nextIter;
		}
		
		if(oneIter.contains(end)) return res;
		else return 0;
	}
	
	public List<String> generateList(char[] word, Map<String, Boolean> visited, HashSet<String> dict) {
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i = 0; i < word.length; i++) {
			char orig = word[i];
			for(char ch = 'a'; ch <= 'z'; ch++) {
				if(ch == orig) continue;
				word[i] = ch;
				String newWord = new String(word);
				if(dict.contains(newWord) && !visited.get(newWord)) {
					list.add(newWord);
					visited.put(newWord, true);
				}
			}
			word[i] = orig;
		}
		
		return list;
	}
	
	// the stupid code, that gets Time Limit Exceed
//	int res;
//	public int ladderLength(String start, String end, HashSet<String> dict) {
//		if(start == null || end == null || dict == null || dict.size() == 0) return 0;
//		Map<String, List<String>> map = generateMap(dict, start, end);
//		res = -1;
//		dfs(start, end, map, 1, new HashSet<String>());
//		return (res == -1) ? 0 : res;
//	}
//	
//	public void dfs(String currentWord, String end, Map<String, List<String>> map, int count, HashSet<String> visited) {
//		if(currentWord.equals(end)) {
//			if(res == -1 || count < res) res = count;
//			return;
//		}
//		if(res != -1 && count > res) return;
//		visited.add(currentWord); // bug2, forget visited Set, so get infinite loop
//		for(String word : map.get(currentWord)) {
//			if(!visited.contains(word)) dfs(word, end, map, count+1, visited);
//		}
//		visited.remove(currentWord);
//	}
//	
//	public Map<String, List<String>> generateMap(HashSet<String> dict, String start, String end) {
//		Map<String, List<String>> map = new HashMap<String, List<String>>();
//		map.put(start, generateList(start.toCharArray(), dict, end));
//		for(String word : dict) {
//			map.put(word, generateList(word.toCharArray(), dict, end));
//		}
//		return map;
//	}
//	
//	public List<String> generateList(char[] word, HashSet<String> dict, String end) {
//		List<String> list = new ArrayList<String>();
//		for(int i = 0; i < word.length; i++) {
//			char orig = word[i];
//			for(char ch = 'a'; ch <= 'z'; ch++) {
//				if(ch == orig) continue;		// bug1
//				word[i] = ch;
//				String newWord = new String(word);
//				if(dict.contains(newWord) || newWord.equals(end)) {
//					list.add(newWord);
//				}
//			}
//			word[i] = orig;
//		}
//		return list;
//	}
}

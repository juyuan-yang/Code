/*
 * Word Break - AC Rate: 245/1374 - My Submissions
Given a string s and a dictionary of words dict, 
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 */

package WordBreak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// AC on 2nd try :(
public class Solution {
	public boolean wordBreak(String s, Set<String> dict) {
		if(s == null || s.length() == 0 || dict == null || dict.size() == 0) return false;
		
		Map<Integer, ArrayList<Integer>> pos2nexts = new HashMap<Integer, ArrayList<Integer>>();
		for(String word : dict) {
			int begin = 0, temp;
			while(true) {
				temp = s.indexOf(word, begin);
				if(temp == -1) break;
				else {
					if(pos2nexts.containsKey(temp)) pos2nexts.get(temp).add(word.length());
					else {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(word.length());
						pos2nexts.put(temp, list);
					}
				}
				begin = temp + 1; // bug here, should use +1, as there may be duplicates, like aaaaaa
			}
		}
		
		boolean[] res = new boolean[s.length()];
		res[0] = pos2nexts.containsKey(0);
		int max = -1;
		for(int i = 0; i < s.length(); i++) {
			if(res[i]) {
				if(pos2nexts.containsKey(i)) {
					for(int step : pos2nexts.get(i)) {
						if(i + step == s.length()) return true;
						else if(i + step < s.length()) {
							if(i + step > max) max = i + step;
							res[i+step] = true;
						}
					}
				}
			} else if(i > max) return false;
		}
		
		return false;
	}
}

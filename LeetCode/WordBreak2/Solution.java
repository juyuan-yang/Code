/*
 * Word Break II - AC Rate: 23/214 - My Submissions
Given a string s and a dictionary of words dict, 
add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
 */

package WordBreak2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// AC after several tries :(
public class Solution {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		Map<Integer, ArrayList<Integer>> pos2word = new HashMap<Integer, ArrayList<Integer>>();
		boolean[] reachable = new boolean[s.length() + 1];
		reachable[0] = true;
		int maxLen = 0;
		
		for(String word : dict) {
			if(word.length() > maxLen) maxLen = word.length();
		}
		
		for(int i = 0; i < s.length(); i++) {
		    if(reachable[i]) {
		        for(int j = i + 1; j <= s.length() && j <= i + maxLen; j++) {
		            String temp = s.substring(i, j);
			        if(dict.contains(temp)) {
			            reachable[j] = true;
			            if(pos2word.containsKey(j)) {
			                pos2word.get(j).add(i);
			            } else {
			                ArrayList<Integer> list = new ArrayList<Integer>();
			                list.add(i);
			                pos2word.put(j, list);
			            }
			        }
		        }
		    }
		}
		
		if(!reachable[s.length()]) return res;
		
		tryNext(res, s, s.length(), new ArrayList<String>(), pos2word);
		return res;
	}
	
	public void tryNext(ArrayList<String> res, String s, int pos, ArrayList<String> has,
			Map<Integer, ArrayList<Integer>> pos2word) {
		if(pos == 0) {
			StringBuilder sb = new StringBuilder();
			for(int i = has.size() - 1; i > 0; i--) sb.append(has.get(i) + " ");
			sb.append(has.get(0));
			res.add(sb.toString());
			return;
		}
		if(!pos2word.containsKey(pos)) return;
		for(int pre : pos2word.get(pos)) {
		    String temp = s.substring(pre, pos);
		    has.add(temp);
		    tryNext(res, s, pre, has, pos2word);
		    has.remove(has.size() - 1);
		}
	}
	
	// TLE again -.-
//	public ArrayList<String> wordBreak(String s, Set<String> dict) {
//		ArrayList<String> res = new ArrayList<String>();
//		Set<String> dictPrefix = new HashSet<String>();
//		int maxLen = 0, totalLen = 0;
//		
//		for(String word : dict) {
//			for(int i = 1; i <= word.length(); i++) { // bug, <=
//				dictPrefix.add(word.substring(0, i));
//			}
//			totalLen += word.length();
//			if(word.length() > maxLen) maxLen = word.length();
//		}
//		if(totalLen < s.length()) return res;
//		tryNext(res, s, 0, new ArrayList<String>(), dict, dictPrefix, maxLen);
//		return res;
//	}
//	
//	public void tryNext(ArrayList<String> res, String s, int pos, ArrayList<String> has,
//			Set<String> dict, Set<String> dictPrefix, int maxLen) {
//		if(pos == s.length()) {
//			StringBuilder sb = new StringBuilder();
//			sb.append(has.get(0));
//			for(int i = 1; i < has.size(); i++) sb.append(" " + has.get(i));
//			res.add(sb.toString());
//			return;
//		} else if(pos > s.length()) return;
//		for(int i = pos + 1; i <= pos + maxLen && i <= s.length(); i++) { // bug, <=
//			String temp = s.substring(pos, i);
//			if(!dictPrefix.contains(temp)) break;
//			else if(dict.contains(temp)) {
//				has.add(temp);
//				tryNext(res, s, i, has, dict, dictPrefix, maxLen);
//				has.remove(has.size() - 1);
//			}
//		}
//	}
	
	// TLE 
//	public ArrayList<String> wordBreak(String s, Set<String> dict) {
//		ArrayList<String> res = new ArrayList<String>();
//		Map<Integer, ArrayList<String>> pos2words = new HashMap<Integer, ArrayList<String>>();
//		int total = 0;
//		
//		for(String word : dict) {
//		    total += word.length();
//			int begin = 0, next = s.indexOf(word, begin);
//			while(next != -1) {
//				if(pos2words.containsKey(next)) {
//					pos2words.get(next).add(word);
//				} else {
//					ArrayList<String> list = new ArrayList<String>();
//					list.add(word);
//					pos2words.put(next, list);
//				}
//				begin = next + 1;
//				next = s.indexOf(word, begin);
//			}
//		}
//		if(total < s.length()) return res;
//		tryNext(s, res, pos2words, 0, new ArrayList<String>());
//		
//		return res;
//	}
//	
//	public void tryNext(String s, ArrayList<String> res, Map<Integer, ArrayList<String>> pos2words,
//				int pos, ArrayList<String> has) {
//		if(pos > s.length()) return;
//		else if(pos == s.length()) {
//			StringBuilder sb = new StringBuilder();
//			for(String word : has) sb.append(word + " ");
//			sb.deleteCharAt(sb.length() - 1);
//			res.add(sb.toString());
//			return;
//		}
//		if(!pos2words.containsKey(pos)) return;
//		for(String word : pos2words.get(pos)) {
//			has.add(word);
//			tryNext(s, res, pos2words, pos + word.length(), has);
//			has.remove(has.size()-1);
//		}
//	}
}

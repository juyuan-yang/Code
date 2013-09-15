/*
 * Restore IP Addresses - Aug 8 '12 - 4543 / 16957
Given a string containing only digits, 
restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */

package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// AC on 4th try :(
// See the bug list below
public class Solution {
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> res = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		if(s != null && s.length() > 3) {
			separate(set, s, new int[4], 0, 0);
			res.addAll(set);
		}
		return res;
	}
	
	public void separate(Set<String> set, String s, int[] nums, int pos, int start) {
		if(pos == 4) {
			if(start != s.length()) return; // bug3: make sure every digit is used!
			StringBuilder sb = new StringBuilder();
			sb.append(nums[0]);
			for(int i = 1; i < 4; i++) sb.append("." + nums[i]);
			set.add(sb.toString());
			return;
		}
		for(int i = 1; i < 4; i++) {
			if(start + i <= s.length() - 3 + pos) { // bug1: so stupid here! need (3 - pos)
				String str = s.substring(start, start + i);
				int temp = Integer.parseInt(str);
				if(temp < 256 && (i == 1 || s.charAt(start) != '0')) { // bug2: "01" is illegal!
					nums[pos] = temp;
					separate(set, s, nums, pos+1, start + i);
				}
			}
		}
	}
}

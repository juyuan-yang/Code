/*
 * Letter Combinations of a Phone Number - AC Rate: 965/3916 My Submissions
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, 
your answer could be in any order you want.
 */

package LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;

// AC! Only get compilation error, need to cast from int to char!
public class Solution {
    private int[] offset = new int[] {0, 3, 6, 9, 12, 15, 19, 22, 26};
    
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0) {
        	res.add("");	// what??...
        	return res;
        }
        tryNext(digits, 0, new char[digits.length()], res);
        return res;
    }
    
    public void tryNext(String digits, int pos, char[] has, ArrayList<String> res) {
        if(pos == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < pos; i++) sb.append(has[i]);
            res.add(sb.toString());
            return;
        }
        char ch = digits.charAt(pos);
        if(ch == '1') {
            has[pos] = '_';
            tryNext(digits, pos+1, has, res);
        } else if(ch == '0') {
            has[pos] = ' ';
            tryNext(digits, pos+1, has, res);
        } else {
            int k = ch - '2';
            for(int i = offset[k]; i < offset[k+1]; i++) {
                has[pos] = (char) (i + 'a');
                tryNext(digits, pos+1, has, res);
            }
        }
    }
}

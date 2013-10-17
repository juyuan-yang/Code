/*
 * Roman to Integer - AC Rate: 899/2725 My Submissions
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */

package RomantoInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> ch2num = new HashMap<Character, Integer>();
        ch2num.put('I', 1);
        ch2num.put('V', 5);
        ch2num.put('X', 10);
        ch2num.put('L', 50);
        ch2num.put('C', 100);
        ch2num.put('D', 500);
        ch2num.put('M', 1000);
        
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(i + 1 < s.length() && ch2num.get(ch) < ch2num.get(s.charAt(i+1))) {
                res -= ch2num.get(ch);
            } else res += ch2num.get(ch);
        }
        
        return res;
    }
}

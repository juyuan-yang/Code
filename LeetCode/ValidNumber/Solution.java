/*
 * Valid Number - AC Rate: 205/2162 My Submissions
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. 
You should gather all requirements up front before implementing one.
 */

package ValidNumber;

// AC after several tries... see comments
public class Solution {
    public boolean isNumber(String s) {
        if(s == null) return false;
        s = s.trim();
        if(s.length() == 0) return false;
        if(s.contains("e")) {
        	int index = s.indexOf('e');
        	// ?e[int], after e, it must be int, rather than float
        	return validNum(s.substring(0, index)) 
        			&& validInt(s.substring(index + 1, s.length()), false, true);
        } else {
        	return validNum(s);
        }
    }
    
    public boolean validNum(String s) {
        if(s.length() == 0) return false; // bug, need to check here
    	if(s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);
    	if(s.contains(".")) {
    		int index = s.indexOf('.');
    		// s.length() > 1 to guarantee no "."
    		return s.length() > 1 && validInt(s.substring(0, index), true, false) 
    		        && validInt(s.substring(index + 1, s.length()), true, false);
    	} else {
    	    // s.length() > 0 to guarantee no "+" / "-"
    		return s.length() > 0 && validInt(s, true, false);
    	}
    }
    
    // bug, validEmpty & hasSign needed... for numbers like, "6e", "1e+6"
    public boolean validInt(String s, boolean validEmpty, boolean hasSign) {
        if(s.length() == 0) return validEmpty; // bug, .1 and 3. is allowed...
        if(hasSign) {
            if(s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);
            if(s.length() == 0) return false; // bug, "6e+"
        }
        for(int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	if(!(ch >= '0' && ch <= '9')) return false; 
        }
        return true;
    }
}

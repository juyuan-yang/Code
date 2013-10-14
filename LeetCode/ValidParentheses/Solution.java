/*
 * Valid Parentheses - AC Rate: 1154/4079 My Submissions
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

package ValidParentheses;

import java.util.Stack;

// AC on 2nd try :(
public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') stack.add(i);
            else {
                if(stack.isEmpty()) return false;
                char pre = s.charAt(stack.pop());
                
                switch(ch) {
	                case ')':
	                    if(pre != '(') return false;
	                    break;
	                case '}':
	                    if(pre != '{') return false;
	                    break;
	                case ']':
	                    if(pre != '[') return false;
	                    break;
	                default:
	                    return false;
                }
            }
        }
        
        return stack.isEmpty(); // bug, I use true at first :(
    }
}

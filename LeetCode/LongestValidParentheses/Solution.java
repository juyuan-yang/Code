/*
 * Longest Valid Parentheses - AC Rate: 795/4659 My Submissions
Given a string containing just the characters '(' and ')', 
find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", 
which has length = 4.
 */

package LongestValidParentheses;

import java.util.Stack;

// AC on 2nd try, 1st failed on a silly mistake...
public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] res = new int[s.length()];
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.add(i);
            } else {
                if(!stack.isEmpty()) {
                    int pre = stack.pop();
                    res[i] = (pre == 0 ? 0 : res[pre-1]) + i - pre + 1; // bug, use 2 at first...
                    if(res[i] > max) max = res[i];
                }
            }
        }
        
        return max;
    }
}

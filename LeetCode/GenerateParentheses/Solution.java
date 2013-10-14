/*
 * Generate Parentheses - AC Rate: 1078/3630 My Submissions
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 */

package GenerateParentheses;

import java.util.ArrayList;

// AC on 1st try :)
public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if(n <= 0) return res;
        char[] has = new char[n * 2];
        tryNext(res, has, 0, n, 0, 0);
        return res;
    }
    
    public void tryNext(ArrayList<String> res, char[] has, int pos, int n, int i, int j) {
        if(i == n && j == n) {
            StringBuilder sb = new StringBuilder();
            for(int t = 0; t < has.length; t++) sb.append(has[t]);
            res.add(sb.toString());
            return;
        } else {
            if(i < n) {
                has[pos] = '(';
                tryNext(res, has, pos+1, n, i+1, j);
            }
            if(i > j) {
                has[pos] = ')';
                tryNext(res, has, pos+1, n, i, j+1);
            }
        }
    }
}

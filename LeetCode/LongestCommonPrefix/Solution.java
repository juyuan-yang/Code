/*
 * Longest Common Prefix - AC Rate: 1291/4804 My Submissions
Write a function to find the longest common prefix string amongst an array of strings.
 */

package LongestCommonPrefix;

// AC on 2nd try :( 
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        int min = strs[0].length();
        
        for(int add = 1; add < strs.length; add *= 2) { // I wrote add < min at first = =|||
            for(int i = 0; i + add < strs.length; i += add * 2) {
                int temp = getCommon(strs[i], strs[i+add], min);
                if(temp < min) min = temp;
            }
        }
        if(min == 0) return "";
        return strs[0].substring(0, min);
    }
    
    public int getCommon(String a, String b, int limit) {
        if(a.length() < limit) limit = a.length();
        if(b.length() < limit) limit = b.length();
        
        for(int i = 0; i < limit; i++) {
            if(a.charAt(i) != b.charAt(i)) return i;
        }
        return limit;
    }
}

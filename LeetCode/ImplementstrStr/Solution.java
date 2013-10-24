/*
 * Implement strStr() - AC Rate: 1039/5215 My Submissions
Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, 
or null if needle is not part of haystack.
 */

package ImplementstrStr;

// AC on 1st try =.=
public class Solution {
	public String strStr(String haystack, String needle) {
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            for( ; j < needle.length(); j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)) break;
            }
            if(j == needle.length()) {
                return haystack.substring(i);
            }
        }
        return null;
	}
}

/*
 * ZigZag Conversion - AC Rate: 896/4142 My Submissions
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

package ZigZagConversion;

// AC on 2nd try :( a typo
public class Solution {
    public String convert(String s, int nRows) {
        if(s == null || s.length() == 0) return "";
        if(nRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        if(nRows == 2) {
            for(int i = 0; i < s.length(); i += 2) sb.append(s.charAt(i));
            for(int i = 1; i < s.length(); i += 2) sb.append(s.charAt(i));
            return sb.toString();
        }
        for(int i = 0; i < nRows; i++) {
            if(i == 0 || i == nRows-1) {
                for(int j = i; j < s.length(); j += nRows * 2 - 2) sb.append(s.charAt(j));
            } else {
                for(int j = i; j < s.length(); j += nRows * 2 - 2) {
                    sb.append(s.charAt(j));
                    if(j + 2 * nRows - 2 - 2 * i < s.length()) sb.append(s.charAt(j + 2 * nRows - 2 - 2 * i));
                }
            }
        }
        return sb.toString();
    }
}

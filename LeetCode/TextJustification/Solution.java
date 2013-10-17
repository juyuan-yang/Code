/*
 * Text Justification - AC Rate: 119/960 My Submissions
Given an array of words and a length L, format the text such that each line 
has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can 
in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. 
If the number of spaces on a line do not divide evenly between words, 
the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

click to show corner cases.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
 */

package TextJustification;

import java.util.ArrayList;

// AC on 2nd try... For 1st try, I missed that, last line no need of Justification
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		s.fullJustify(new String[] {"What","must","be","shall","be."}, 12);
	}
	
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> res = new ArrayList<String>();
        for(int i = 0; i < words.length; i++) {
            int length = words[i].length(), j = i;
            while(length <= L) {
                j++;
                if(j == words.length) break;
                length += 1 + words[j].length();
            }
            res.add(justify(words, i, j, L));
            i = j - 1;
        }
        return res;
    }
    
    public String justify(String[] words, int i, int j, int L) {
    	StringBuilder sb = new StringBuilder();
        sb.append(words[i]);
        
    	if(i+1 < j) {
    		int len = 0;
            for(int k = i; k < j; k++) len += words[k].length();
            
            int blanks = (L - len) / (j - i - 1);
            int extra = L - len - blanks * (j - i - 1);
            if(j == words.length) {
            	blanks = 1;
            	extra = 0;
            }
            
            char[] blk = new char[blanks];
            for(int k = 0; k < blanks; k++) blk[k] = ' ';
            
            for(int k = i + 1; k < j; k++) {
            	sb.append(blk);
            	if(extra > 0) {
            		sb.append(' ');
            		extra--;
            	}
            	sb.append(words[k]);
            }
    	} 
        while(sb.length() < L) sb.append(' ');
        return sb.toString();
    }
}

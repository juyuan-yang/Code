/*
 * Count and Say - AC Rate: 566/2142 - My Submissions
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 */

package CountandSay;

// AC after several tries :( Made so many silly mistakes
public class Solution {
    public String countAndSay(int n) {
        String str = "1";
        int num = 1;
        
        while(num < n) {
            num++;
            StringBuilder sb = new StringBuilder();
            int base = -1, count = 0, cur = 0;
            while(cur < str.length()) {
                if(base == -1) {
                    base = cur;
                    count = 1;
                } else if(str.charAt(base) == str.charAt(cur)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(str.charAt(base));
                    base = cur;
                    count = 1;
                }
                cur++;
            }
            if(base != -1) {
                sb.append(count);
                sb.append(str.charAt(base));
            }
            str = sb.toString();
        }
        
        return str;
    }
}

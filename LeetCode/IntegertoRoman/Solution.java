/*
 * Integer to Roman - AC Rate: 842/2645 My Submissions
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
 */

package IntegertoRoman;

// AC on 1st try, after several typos...
public class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if(num > 999) {
            sb.append(intToRoman(num / 1000, 'M', ' ', ' '));
            num %= 1000;
        }
        if(num > 99) {
            sb.append(intToRoman(num / 100, 'C', 'D', 'M'));
            num %= 100;
        }
        if(num > 9) {
            sb.append(intToRoman(num / 10, 'X', 'L', 'C'));
            num %= 10;
        }
        sb.append(intToRoman(num, 'I', 'V', 'X'));
        return sb.toString();
    }
    
    public String intToRoman(int digit, char base, char high, char next) {
        StringBuilder sb = new StringBuilder();
        if(digit >= 0 && digit < 4) {
            for(int i = 0; i < digit; i++) sb.append(base);
        } else if(digit == 4) {
            sb.append(base).append(high);
        } else if(digit >= 5 && digit < 9) {
            sb.append(high);
            for(int i = 0; i < digit - 5; i++) sb.append(base);
        } else if(digit == 9) {
            sb.append(base).append(next);
        }
        
        return sb.toString();
    }
}

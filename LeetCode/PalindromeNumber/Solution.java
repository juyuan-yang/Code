/*
 * Palindrome Number - AC Rate: 1752/5982 My Submissions
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", 
you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
 */

package PalindromeNumber;

// AC on 2nd try :(
public class Solution {
	public boolean isPalindrome(int x) {
        if(x < 0) return false; // bug...
        
        int exp = 1, bits = 1, low = 1;
        
        while(x / 10 >= exp) {
            exp = exp * 10;
            bits++;
        }
        
        while(bits > 1) {
            if((x / exp) % 10 != (x / low) % 10) return false; // bug, don't forget % 10
            exp /= 10;
            low *= 10;
            bits -= 2;
        }
        return true;
	}
}

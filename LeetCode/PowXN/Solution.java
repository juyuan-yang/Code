/*
 * Pow(x, n) - AC Rate: 1018/3926 - My Submissions
Implement pow(x, n).
 */

package PowXN;

public class Solution {
    public double pow(double x, int n) {
        double res = 1;
        boolean neg = n < 0;
        if(n < 0) n = -n;
        
        while(n > 0) {
            if((n & 1) == 1) {
                res *= x;
            }
            n = n >> 1;
            x *= x;
        }
        
        if(neg) return 1 / res;
        else return res;
    }
	
	// AC on 1st try :) n may be negatives!
//    public double pow(double x, int n) {
//        if(n == 0) return 1;
//        else if(n == 1) return x;
//        else if(n == -1) return 1 / x;
//        else {
//            double temp = pow(x, n / 2);
//            temp *= temp;
//            if(n % 2 == 0) return temp;
//            else if(n > 0) return temp * x;
//            else return temp / x;
//        }
//    }
}

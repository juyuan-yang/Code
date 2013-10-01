/*
 * Candy - AC Rate: 10/90 - My Submissions
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 */

package Candy;

// AC on 1st try :)
public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int[] decrease = new int[ratings.length];
        
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) decrease[i] = decrease[i+1] + 1;
            else decrease[i] = 0;
        }
        
        int pre = 0, res = (decrease[0] == 0) ? 1 : (decrease[0] + 1);
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) pre++;
            else pre = 0;
            res += ((decrease[i] > pre) ? decrease[i] : pre) + 1;
        }
        
        return res;
    }
}

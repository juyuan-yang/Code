/*
 * Two Sum - AC Rate: 2947/13303 My Submissions
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) 
are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */

package TwoSum;

import java.util.HashMap;
import java.util.Map;

// AC on 1st try :)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers == null || numbers.length < 2) return res;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target - numbers[i])) {
                int j = map.get(target - numbers[i]);
                res[0] = j + 1;
                res[1] = i + 1;
                return res;
            } else {
                map.put(numbers[i], i);
            }
        }
        
        return res;
    }
}

/*
 * Search Insert Position - AC Rate: 1553/4480 My Submissions
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 ¡ú 2
[1,3,5,6], 2 ¡ú 1
[1,3,5,6], 7 ¡ú 4
[1,3,5,6], 0 ¡ú 0
 */

package SearchInsertPosition;

// AC on 1st try :)
public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0) return 0;
        
        if(target < A[0]) return 0;
        if(target > A[A.length - 1]) return A.length;
        
        int start = 0, end = A.length - 1;
        while(start <= end) {
            int mid = (end - start) / 2 + start;
            if(A[mid] == target) return mid;
            else if(A[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        
        return start;
    }
}

/*
 * Search for a Range - AC Rate: 1028/3774 My Submissions
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */

package SearchforaRange;

// AC on 1st try :)
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        if(A == null || A.length == 0) return res;
        int pos = binarySearch(A, target, 0, A.length-1);
        if(pos == -1) {
            res[0] = res[1] = -1;
        } else {
            int start = 0, end = pos;
            while(start <= end) {
                int mid = (end - start) / 2 + start;
                if(A[mid] == target) end = mid - 1;
                else start = mid + 1;
            }
            res[0] = start;
            
            start = pos;
            end = A.length - 1;
            while(start <= end) {
                int mid = (end - start) / 2 + start;
                if(A[mid] == target) start = mid + 1;
                else end = mid - 1;
            }
            res[1] = end;
        }
        return res;
    }
    
    public int binarySearch(int[] A, int target, int start, int end) {
        if(A[start] > target || A[end] < target) return -1;
        while(start <= end) {
            int mid = (end - start) / 2 + start;
            if(A[mid] == target) return mid;
            else if(A[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}

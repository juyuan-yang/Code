/*
 * Remove Duplicates from Sorted Array - AC Rate: 1546/4614 - My Submissions
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
 */

package RemoveDuplicatesfromSortedArray;

// AC on 1st try :)
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0) return 0;
        int l = 0, pre = -1;
        for(int cur = 0; cur < A.length; cur++) {
            if(pre == -1 || A[cur] != A[pre]) {
                pre = cur;
                A[l++] = A[cur];
            } 
        }
        return l;
    }
}

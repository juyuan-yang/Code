/*
 * Remove Element - AC Rate: 1469/4391 My Submissions
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */

package RemoveElement;

public class Solution{
	// AC on 1st try :)
    public int removeElement(int[] A, int elem) {
        if(A == null || A.length == 0) return 0;
        int l = 0;
        for(int cur = 0; cur < A.length; cur++) {
            if(A[cur] != elem) {
                A[l++] = A[cur];
            }
        }
        return l;
    }
}

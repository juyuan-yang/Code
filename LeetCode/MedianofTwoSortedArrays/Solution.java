/*
 * Median of Two Sorted Arrays - AC Rate: 1370/8981 My Submissions
 * 
There are two sorted arrays A and B of size m and n respectively. 
Find the median of the two sorted arrays. 
The overall run time complexity should be O(log (m+n)).
 */

package MedianofTwoSortedArrays;

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
    	if(A == null) A = new int[0];
        int l = A.length + B.length;
        if(l % 2 == 0) 
            return findKth(A, B, 0, A.length - 1, 0, B.length - 1, l / 2);
        else 
            return (findKth(A, B, 0, A.length - 1, 0, B.length - 1, l / 2) + findKth(A, B, 0, A.length - 1, 0, B.length - 1, l / 2 + 1)) / 2.0;
    }
    
    public int findKth(int A[], int B[], int as, int ae, int bs, int be, int k) {
        if(as > ae) return B[bs + k - 1];
        if(bs > be) return A[as + k - 1];
        int am = (ae - as) / 2 + as, bm = (be - bs) / 2 + bs;
        if(A[am] >= B[bm]) {
            int l = am - as + bm - bs + 1;
            if(k > l) return findKth(A, B, am, ae, bm+1, be, k - l);
            else return findKth(A, B, as, am-1, bs, be, k);
        } else {
            int l = am - as + bm - bs + 1;
            if(k > l) return findKth(A, B, am+1, ae, bs, be, k - l);
            else return findKth(A, B, as, ae, bs, bm-1, k);
        }
    }
}

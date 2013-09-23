/*
 * Search in Rotated Sorted Array - AC Rate: 162/571 - My Submissions
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, 
otherwise return -1.

You may assume no duplicate exists in the array.
 */

package SearchinRotatedSortedArray;

// AC on 1st try :)
public class Solution {
	public int search(int[] A, int target) {
		if(A == null || A.length == 0) return -1;
		return rotatedBinarySearch(A, target, 0, A.length - 1);
	}
	
	public int rotatedBinarySearch(int[] A, int target, int start, int end) {
		if(start == end) return (target == A[start]) ? start : -1;
		int mid = (start + end) / 2;
		if(target == A[mid]) return mid;
		
		int res;
		if(A[start] <= A[mid]) {
			res = binarySearch(A, target, start, mid-1);
		} else {
			res = rotatedBinarySearch(A, target, start, mid-1);
		}
		if(res != -1) return res;
		if(A[mid] <= A[end]) {
			res = binarySearch(A, target, mid+1, end);
		} else {
			res = rotatedBinarySearch(A, target, mid+1, end);
		}
		return res;
	}
	
	public int binarySearch(int[] A, int target, int start, int end) {
		while(start <= end) {
			int mid = (start + end) / 2; // bug, put it before while :(
			if(target == A[mid]) return mid;
			else if(target > A[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}
}

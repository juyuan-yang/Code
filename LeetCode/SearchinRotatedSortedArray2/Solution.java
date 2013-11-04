/*
 * Search in Rotated Sorted Array II - AC Rate: 69/219 - My Submissions
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
 */

package SearchinRotatedSortedArray2;

public class Solution {
	// AC on 3rd try :( A simplified version
	public boolean search(int[] A, int target) {
		if(A == null || A.length == 0) return false;
		
        return search(A, target, 0, A.length - 1);
	}
	
	public boolean search(int[] A, int target, int start, int end) {
	    int mid;
		while(start <= end) {
		    mid = (end - start) / 2 + start;
		    if(A[mid] == target) return true;
		    else if(A[start] < A[mid]) {
		        if(target < A[mid] && target >= A[start]) end = mid - 1;
		        else start = mid + 1;
		    } else if(A[mid] < A[end]) {
		        if(target > A[mid] && target <= A[end]) start = mid + 1;
		        else end = mid - 1;
		    } else { // bug here, start++ / end-- is not enough!
		        if(search(A, target, start, mid - 1)) return true;
		        else return search(A, target, mid + 1, end);
		    }
		}
		
		return false;
	}
	
	// AC after several tries :( Edge cases!
//	public boolean search(int[] A, int target) {
//		if(A == null || A.length == 0) return false;
//		return rotatedBinarySearch(A, target, 0, A.length - 1);
//	}
//	
//	public boolean rotatedBinarySearch(int[] A, int target, int start, int end) {
//	    if(start > end) return false;
//		if(start == end) return target == A[start];
//		int mid = (start + end) / 2;
//		if(target == A[mid]) return true;
//		
//		boolean res;
//		if(A[start] < A[mid]) {
//			res = binarySearch(A, target, start, mid-1);
//		} else {
//			res = rotatedBinarySearch(A, target, start, mid-1);
//		}
//		if(res) return true;
//		if(A[mid] < A[end]) {
//			res = binarySearch(A, target, mid+1, end);
//		} else {
//			res = rotatedBinarySearch(A, target, mid+1, end);
//		}
//		return res;
//	}
//	
//	public boolean binarySearch(int[] A, int target, int start, int end) {
//		while(start <= end) {
//		    int mid = (start + end) / 2;
//			if(target == A[mid]) return true;
//			else if(target > A[mid]) {
//				start = mid + 1;
//			} else {
//				end = mid - 1;
//			}
//		}
//		return false;
//	}
}

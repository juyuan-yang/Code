/*
 * Permutation Sequence - AC Rate: 260/1299 - My Submissions
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 */

package PermutationSequence;

// AC on 1st try :) But I think there must be simpler way to write codes?
public class Solution {
	public String getPermutation(int n, int k) {
		boolean[] used = new boolean[n];
		int possible = 1, i = 1;
		while(i < n) {
			possible *= i;
			i++;
		}
		
		StringBuilder sb = new StringBuilder();
		k--;
		for(i = n - 1; i >= 0; i--) {
			int pos = k / possible;
			k -= pos * possible;
			if(i != 0) possible /= i;
			
			for(int j = 0; j < n; j++)
				if(!used[j]) {
					if(pos == 0) {
						sb.append(j+1);
						used[j] = true;
						break;
					}
					pos--;
				}
		}
		return sb.toString();
	}
}

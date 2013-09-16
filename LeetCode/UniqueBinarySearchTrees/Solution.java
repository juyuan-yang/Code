/*
 * Unique Binary Search Trees - Aug 27 '12 - 5456 / 10302
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

package UniqueBinarySearchTrees;

// AC on 2nd try :(
public class Solution {
	public int numTrees(int n) {
		if(n <= 0) return 0;
		int[] res = new int[n+1];
		res[0] = res[1] = 1;
		for(int i = 2; i <= n; i++) {
			for(int mid = 1; mid <= i; mid++) {
				res[i] += res[mid-1] * res[i-mid]; // bug: + => *
			}
		}
		return res[n];
	}
}

/*
 * Next Permutation - AC Rate: 775/3059 My Submissions
Implement next permutation, which rearranges numbers into the lexicographically 
next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order 
(ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs 
are in the right-hand column.
1,2,3 �� 1,3,2
3,2,1 �� 1,2,3
1,1,5 �� 1,5,1
 */

package NextPermutation;

// AC after several tries :(
public class Solution {
	public void nextPermutation(int[] num) {
		if(num == null || num.length < 2) return;
		int cur = num.length - 1;
		if(num[cur] > num[cur-1]) {
			exchange(num, cur, cur-1);
			return;
		} else {
			while(cur > 0 && num[cur] <= num[cur-1]) cur--; // bug, should include '=' here
			if(cur != 0) {
				int min = num[cur] - num[cur-1], pos = cur;
				for( int i = cur+1; i < num.length; i++) {
					if(num[i] > num[cur-1] && num[i] - num[cur-1] < min) {
						min = num[i] - num[cur-1];
						pos = i;
					}
				}
				exchange(num, cur-1, pos); // there might be same items in array
				while(pos + 1 < num.length && num[pos] < num[pos+1]) { // so need to check order after exchange
					exchange(num, pos, pos+1);
					pos++;
				}
			}
			for(int i = cur; i < (num.length - cur) / 2 + cur; i++) {
				exchange(num, i, num.length - 1 - (i - cur)); // bug, write the correct index
			}
		}
	}
	
	public void exchange(int[] num, int p1, int p2) {
		int temp = num[p1];
		num[p1] = num[p2];
		num[p2] = temp;
	}
}

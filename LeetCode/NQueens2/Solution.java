/*
 * N-Queens II - AC Rate: 362/1522 - My Submissions
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.

 */

package NQueens2;

// AC on 1st try :)
public class Solution {
	int res;
	public int totalNQueens(int n) {
		res = 0;
		if(n == 0) return res;
        int[] pos = new int[n];
        boolean[] left = new boolean[n*2], right = new boolean[n*2], used = new boolean[n];
        
        tryNext(n, 0, pos, used, left, right);
        
        return res;
	}

    public void tryNext(int n, int level, int[] pos, boolean[] used, boolean[] left, boolean[] right) {
        if(level == n) {
        	res++;
            return;
        }
        for(int i = 0; i < n; i++){
            if(!used[i] && !left[level - i + n] && !right[level + i]) {
                used[i] = true;
                pos[level] = i;
                left[level - i + n] = true;
                right[level + i] = true;
                tryNext(n, level+1, pos, used, left, right);
                left[level - i + n] = false;
                right[level + i] = false;
                used[i] = false;
            }
        }
    }
}

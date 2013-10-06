/*
 * N-Queens - AC Rate: 476/1895 - My Submissions
The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard 
such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, 
where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */

package NQueens;

import java.util.ArrayList;

// AC on 2nd try :( but just something like a typo..
public class Solution {
	public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        if(n == 0) return res;
        int[] pos = new int[n];
        boolean[] left = new boolean[n*2], right = new boolean[n*2], used = new boolean[n];
        
        tryNext(n, 0, res, pos, used, left, right);
        return res;
    }
    
    public void tryNext(int n, int level, ArrayList<String[]> res, int[] pos, 
                    boolean[] used, boolean[] left, boolean[] right) {
        if(level == n) {
            String[] list = new String[n];
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(pos[i] == j) sb.append('Q');
                    else sb.append('.');
                }
                list[i] = sb.toString();
            }
            res.add(list);
            return;
        }
        for(int i = 0; i < n; i++){
            if(!used[i] && !left[level - i + n] && !right[level + i]) {
                used[i] = true;
                pos[level] = i;
                left[level - i + n] = true;
                right[level + i] = true;
                tryNext(n, level+1, res, pos, used, left, right);
                left[level - i + n] = false;
                right[level + i] = false;
                used[i] = false;
            }
        }
    }
}

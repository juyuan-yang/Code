/*
 * Word Search - AC Rate: 91/432 - My Submissions
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */

package WordSearch;

// AC on 1st try :)
public class Solution {
	public boolean exist(char[][] board, String word) {
		if(board == null || word == null) return false;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == word.charAt(0)) {
					if(exist(board, word, 1, i, j)) return true;
				}
			}
		}
		return false;
	}
	
	public boolean exist(char[][] board, String word, int pos, int s, int t) {
		if(pos == word.length()) return true;
		char orig = board[s][t];
		board[s][t] = ' ';
		int[] x = new int[]{1, 0, -1, 0}, y = new int[]{0, 1, 0, -1};
		
		for(int l = 0; l < 4; l++) {
			int i = s + x[l], j = t + y[l];
			if(i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
				if(board[i][j] == word.charAt(pos)) {
					if(exist(board, word, pos + 1, i, j)) return true;
				}
			}
		}
		
		board[s][t] = orig;
		return false;
	}
}

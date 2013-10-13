/*
 * Valid Sudoku - AC Rate: 456/1645 - My Submissions
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.
 */

package ValidSudoku;

// AC on 2nd try :( a silly mistake
public class Solution {
	public boolean isValidSudoku(char[][] board) {
		if(board == null || board.length != 9 || board[0].length != 9) return false;
		for(int i = 0; i < 9; i++) {
			if(!checkRowCol(board, i, true)) return false;
			if(!checkRowCol(board, i, false)) return false;
		}
		for(int i = 1; i <= 7; i += 3) 
			for(int j = 1; j <= 7; j += 3) {
				if(!checkBox(board, i, j)) return false;
			}
		return true;
	}
	
	public boolean checkBox(char[][] board, int s, int t) {
		boolean[] has = new boolean[9];
		for(int i = -1; i <= 1; i++)
			for(int j = -1; j <= 1; j++){
				char ch = board[s + i][t + j];
				if(ch != '.') {
					if(has[ch - '1']) return false;
					has[ch - '1'] = true;
				}
			}
		return true;
	}
	
	public boolean checkRowCol(char[][] board, int index, boolean row) {
		boolean[] has = new boolean[9];
		for(int i = 0; i < 9; i ++) {
			char ch = (row ? board[index][i] : board[i][index]);
			if(ch != '.') {
				if(has[ch - '1']) return false;
				has[ch - '1'] = true;
			}
		}
		return true;
	}
}

/*
 * Surrounded Regions - Feb 22 - 11049 / 41380

Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region .

For example,

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

 */

package SurroundedRegions;

// stupid on 1st try, always forget something in conditions :(
// Runtime error on 2nd try, I guess it's because of too long recursion
public class Solution {
	public void solve(char[][] board) {
		if(board == null || board.length == 0) return;
		int rows = board.length;
		int cols = board[0].length;
		for(int j = 0; j < cols; j++) {
			if(board[0][j] == 'O') checkEachChar(board, 0, j, rows, cols);
			if(board[rows-1][j] == 'O') checkEachChar(board, rows - 1, j, rows, cols);
		}
		for(int i = 1; i < rows - 1; i++) {
			if(board[i][0] == 'O') checkEachChar(board, i, 0, rows, cols);
			if(board[i][cols-1] == 'O') checkEachChar(board, i, cols - 1, rows, cols);
		}
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(board[i][j] == 'A') board[i][j] = 'O';
				else board[i][j] = 'X';
			}
		}
	}
	
	public void checkEachChar(char[][] board, int i, int j, int rows, int cols) {
		board[i][j] = 'A';
		if(i > 0 && board[i-1][j] == 'O') checkEachChar(board, i-1, j, rows, cols);
		if(i < cols-1 && board[i+1][j] == 'O') checkEachChar(board, i+1, j, rows, cols);
		if(j > 0 && board[i][j-1] == 'O') checkEachChar(board, i, j-1, rows, cols);
		if(j < rows-1 && board[i][j+1] == 'O') checkEachChar(board, i, j+1, rows, cols);
	}
}

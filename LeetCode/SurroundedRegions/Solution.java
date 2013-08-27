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
	int[] directX = {-1, 0, 1, 0};
	int[] directY = {0, -1, 0, 1};
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
	
	// 3rd try failed, because of array index out of bound... need to be very careful when assigning board
	// some cell might be added to the queue twice...
	// 4th try may meet TLE sometimes...
	public void checkEachChar(char[][] board, int i, int j, int rows, int cols) {
		int[] Xs = new int[rows * cols];
		int[] Ys = new int[rows * cols];
		int pos = 0, total = 0;
		Xs[total] = i;
		Ys[total++] = j;
		board[i][j] = 'A';
		
		while(pos < total) {
			for(int k = 0; k < 4; k++) {
				if(Xs[pos] + directX[k] > 0 && Xs[pos] + directX[k] < rows - 1 &&
						Ys[pos] + directY[k] > 0 && Ys[pos] + directY[k] < cols - 1
						&& board[Xs[pos] + directX[k]][Ys[pos] + directY[k]] == 'O') {
					Xs[total] = Xs[pos] + directX[k];
					Ys[total++] = Ys[pos] + directY[k];
					board[Xs[pos] + directX[k]][Ys[pos] + directY[k]] = 'A';
				}
			}
			pos++;
		}
	}
}

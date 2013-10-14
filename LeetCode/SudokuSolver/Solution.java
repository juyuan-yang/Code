/*
 * Sudoku Solver - AC Rate: 360/1807 My Submissions
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.


A sudoku puzzle...


...and its solution numbers marked in red.
 */

package SudokuSolver;

// AC on 1st try :)
public class Solution {
	public void solveSudoku(char[][] board) {
		if(board == null || board.length != 9 || board[0].length != 9) return;
		boolean[][] rows = new boolean[9][9], cols = new boolean[9][9], boxs = new boolean[9][9];
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++){
				if(board[i][j] != '.'){
					int temp = board[i][j] - '1';
					rows[i][temp] = true;
					cols[j][temp] = true;
					boxs[(i/3)*3 + j/3][temp] = true;
				}
			}
		
		tryNext(board, 0, 0, rows, cols, boxs);
	}
	
	public boolean tryNext(char[][] board, int s, int t, boolean[][] rows, 
			boolean[][] cols, boolean[][] boxs) {
		while(!(s >= 0 && s < 9 && t >= 0 && t < 9 && board[s][t] == '.')) {
			if(t == 9) {
				t = 0;
				s++;
				if(s == 9) return true;
			} else t++;
		}
		for(int i = 0; i < 9; i++) {
			if(!rows[s][i] && !cols[t][i] && !boxs[(s/3)*3 + t/3][i]) {
				board[s][t] = (char) ('1' + i);
				rows[s][i] = true;
				cols[t][i] = true;
				boxs[(s/3)*3 + t/3][i] = true;
				if(tryNext(board, s, t+1, rows, cols, boxs)) return true;
				rows[s][i] = false;
				cols[t][i] = false;
				boxs[(s/3)*3 + t/3][i] = false;
				board[s][t] = '.';
			}
		}
		return false;
	}
}

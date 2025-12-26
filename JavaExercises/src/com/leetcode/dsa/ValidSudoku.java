package com.leetcode.dsa;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Input: board = 
				[["5","3",".",".","7",".",".",".","."]
				,["6",".",".","1","9","5",".",".","."]
				,[".","9","8",".",".",".",".","6","."]
				,["8",".",".",".","6",".",".",".","3"]
				,["4",".",".","8",".","3",".",".","1"]
				,["7",".",".",".","2",".",".",".","6"]
				,[".","6",".",".",".",".","2","8","."]
				,[".",".",".","4","1","9",".",".","5"]
				,[".",".",".",".","8",".",".","7","9"]]
				Output: true*/
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
		
		char[][] b = {{1, 2, 3}, {4, 56}};
		
		System.out.println(new ValidSudoku().isValidSudoku(board));
		System.out.println(new ValidSudoku().isValidSudoku2(board));
	}
	
    public boolean isValidSudoku(char[][] board) {
    	int l = board.length;
    	
    	Set<Character> set;
    	Set<Character>[] columns = new Set[l];
    	Set<Character>[] blocks = new Set[l];
    	for (int i = 0; i < l; i++) {
    		set = new HashSet<>(l);
    		
            for (int j = 0; j < l; j++) {
                if (board[i][j] == '.') continue;
				if (!set.add(board[i][j])) return false;
				
				if (columns[j] == null) columns[j] = new HashSet<>();
				if (!columns[j].add(board[i][j])) return false;
				
				int k = (i / 3) * 3 + (j / 3);
				if (blocks[k] == null) blocks[k] = new HashSet<>();
				if (!blocks[k].add(board[i][j])) return false;
            }
        }
        
        return true;
    }
	
    public boolean isValidSudoku2(char[][] board) {
    	int l = board.length;
    	
    	for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (board[i][j] == '.') continue;
                
                if (!isCellValid(board, i, j)) return false;
            }
        }
        
        return true;
    }

	private boolean isCellValid(char[][] board, int i, int j) {
    	// check the row, column varies from 0 to <l
    	for (int col = 0; col < 9; col++) {
    		if (col != j && board[i][col] == board[i][j]) {
    			return false;
    		}
    	}
		
    	// check the column, row varies from 0 to <l
    	for (int row = 0; row < 9; row++) {
    		if (row != i && board[row][j] == board[i][j]) {
    			return false;
    		}
    	}
    	
    	// check 3x3 blocks
		int x = (i / 3) * 3;
		int y = (j / 3) * 3;

		for (int r = x; r < (x + 3); r++) {
			for (int c = y; c < (y + 3); c++) {
				if ((r != i || c != j) && board[r][c] == board[i][j]) {
					return false;
				}
			}
		}
    	
    	
		return true;
	}

}

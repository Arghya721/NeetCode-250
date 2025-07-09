// LeetCode Problem: https://leetcode.com/problems/valid-sudoku/

class Solution {
    boolean isValid(char[][] board, int row, int col, char temp){
        for(int i=0; i<9; i++){
            if(board[row][i] == temp)
                return false;
            if(board[i][col] == temp)
                return false;
            
            if(board[(row/3) * 3 + (i/3)][(col/3)*3 + (i%3)] == temp)
                return false;
        }

        return true;
    }


    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] != '.'){
                    char temp = board[i][j];
                    board[i][j] = '.';
                    if(!isValid(board, i, j, temp))
                        return false;
                    board[i][j] = temp;
                }
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(solution.isValidSudoku(board));
    }
}

/* 
79. Word Search
Solved
Medium
Topics
premium lock icon
Companies
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 


*/

class WordSearchGrid {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (dfs(board, word, r, c, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int r, int c, int row, int col, int idx) {
        if (idx == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= row || c >= col || board[r][c] != word.charAt(idx) || board[r][c] == '#') {
            return false;
        }

        board[r][c] = '#';

        boolean res = dfs(board, word, r + 1, c, row, col, idx + 1) ||
                        dfs(board, word, r - 1, c, row, col, idx + 1) ||
                        dfs(board, word, r, c + 1, row, col, idx + 1) ||
                        dfs(board, word, r, c - 1, row, col, idx + 1);
        
        board[r][c] = word.charAt(idx);

        return res;
    }
}

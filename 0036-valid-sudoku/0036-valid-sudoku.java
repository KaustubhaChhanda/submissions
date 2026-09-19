class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                int boxIndex = (row / 3) * 3 + (col / 3);

                if (c != '.') {
                    int value = c - '1';
                    
                    if (rows[row][value] || cols[col][value] || boxes[boxIndex][value]) {
                        return false;
                    } else {
                        rows[row][value] = true;
                        cols[col][value] = true;
                        boxes[boxIndex][value] = true;
                    }
                }
            }
        }

        return true;
    }
}
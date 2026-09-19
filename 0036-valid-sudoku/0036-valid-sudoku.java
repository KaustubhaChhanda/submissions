class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (set.contains(board[i][j])) {
                    return false;
                }

                if (board[i][j] != '.') {
                    set.add(board[i][j]);
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            Set<Character> set = new HashSet<>();

            for (int i = 0; i < 9; i++) {
                if (set.contains(board[i][j])) {
                    return false;
                }

                if (board[i][j] != '.') {
                    set.add(board[i][j]);
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!verifyCube(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean verifyCube(char[][] board, int r, int c) {
        Set<Character> set = new HashSet<>();

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (set.contains(board[i][j])) {
                    return false;
                }
                
                if (board[i][j] != '.') {
                    set.add(board[i][j]);
                }
            }
        }

        return true;
    }
}
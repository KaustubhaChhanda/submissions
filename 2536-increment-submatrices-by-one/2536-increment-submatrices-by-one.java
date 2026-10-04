class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 1][n + 1];

        for (int[] q : queries) {
            int r1 = q[0];
            int c1 = q[1];
            int r2 = q[2];
            int c2 = q[3];

            diff[r1][c1] += 1;
            diff[r1][c2 + 1] -= 1;
            diff[r2 + 1][c1] -= 1;
            diff[r2 + 1][c2 + 1] += 1;
        }

        for (int i = 1; i < diff.length; i++) {
            diff[i][0] = diff[i - 1][0] + diff[i][0];
        }

        for (int j = 1;  j  < diff.length; j++) {
            diff[0][j] = diff[0][j - 1] + diff[0][j];
        }

        for (int i = 1; i < diff.length; i++) {
            for (int j = 1; j < diff.length; j++) {
                diff[i][j] = diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1] + diff[i][j];
            }
        }

        int[][] ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = diff[i][j];
            }
        }

        return ans;
    }
}
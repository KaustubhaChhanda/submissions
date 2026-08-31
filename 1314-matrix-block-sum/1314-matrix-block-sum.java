class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] pre = new int[m][n];
        pre[0][0] = mat[0][0];

        for (int i = 1; i < m; i++) {
            pre[i][0] = pre[i - 1][0] + mat[i][0];
        }

        for (int j = 1; j < n; j++) {
            pre[0][j] = pre[0][j - 1] + mat[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pre[i][j] = mat[i][j] + pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
            }
        }

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = findSum(pre, i - k, j - k, i + k, j + k);
            }
        }

        return ans;
    }

    private int findSum(int[][] pre, int r1, int c1, int r2, int c2) {
        int m = pre.length;
        int n = pre[0].length;

        if (r1 < 0) r1 = 0;
        if (c1 < 0) c1 = 0;
        if (r2 >= m) r2 = m - 1;
        if (c2 >= n) c2 = n - 1;

        int sum = pre[r2][c2];
        int above = r1 > 0 ? pre[r1 - 1][c2] : 0;
        int left = c1 > 0 ? pre[r2][c1 - 1] : 0;
        int top_left = r1 > 0 && c1 > 0 ? pre[r1 - 1][c1 - 1] : 0;

        return sum - above - left + top_left;
    }
}
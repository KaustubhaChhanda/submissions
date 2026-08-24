class NumMatrix {
    int[][] matrix;
    int m;
    int n;
    int[][] pre;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
        pre = new int[m][n];

        for (int i = 0; i < m; i++) {
            pre[i][0] = matrix[i][0];

            for (int j = 1; j < n; j++) {
                pre[i][j] = pre[i][j - 1] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for (int i = row1; i <= row2; i++) {
            if (col1 == 0) {
                sum += pre[i][col2];
            } else {
                sum += pre[i][col2] - pre[i][col1 - 1];
            }
        }

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Left -> Right
            for (int j = colStart; j <= colEnd; j++) {
                list.add(matrix[rowStart][j]);
            }

            rowStart++;

            // Top -> Bottom
            for (int i = rowStart; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);
            }

            colEnd--;

            // Right -> Left
            if (rowStart <= rowEnd) {
                for (int j = colEnd; j >= colStart; j--) {
                    list.add(matrix[rowEnd][j]);
                }
                
                rowEnd--;
            }


            // Bottom -> Top
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    list.add(matrix[i][colStart]);
                }

                colStart++;
            }
        }

        return list;
    }
}
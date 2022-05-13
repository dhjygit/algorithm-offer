public class code_013_二维子矩阵的和 {
    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    }

    static class NumMatrix {
        int[][] arr;

        public NumMatrix(int[][] matrix) {
            arr = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 1; i <= matrix.length; i++)
                for (int j = 1; j <= matrix[0].length; j++)
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + matrix[i - 1][j - 1];
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return arr[row2 + 1][col2 + 1] - arr[row2 + 1][col1] - arr[row1][col2 + 1] + arr[row1][col1];
        }
    }
}

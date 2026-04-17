class NumMatrix {

    int[][] preSum;

    public NumMatrix(int[][] matrix) {
        preSum = new int[matrix.length][matrix[0].length];

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                int topRect = j-1 >= 0 ? preSum[i][j-1] : 0;
                int sideRect = i-1 >=0 ? preSum[i-1][j] : 0;
                int diagRect = (i>0 && j>0) ? preSum[i-1][j-1] : 0;
                preSum[i][j] = matrix[i][j] + topRect + sideRect - diagRect;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int topRect = row1>0 ? preSum[row1-1][col2] : 0;
        int sideRect = col1>0 ? preSum[row2][col1-1] : 0;
        int diagRect = (row1>0 && col1>0) ? preSum[row1-1][col1-1] : 0;

        return preSum[row2][col2] - topRect - sideRect + diagRect;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
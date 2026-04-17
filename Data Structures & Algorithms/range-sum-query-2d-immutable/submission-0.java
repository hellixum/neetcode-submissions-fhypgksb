class NumMatrix {

    int[][] preSum;

    public NumMatrix(int[][] matrix) {
        preSum = new int[matrix.length][matrix[0].length];

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(j == 0) preSum[i][j] = matrix[i][j];
                else preSum[i][j] = matrix[i][j] + preSum[i][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for(int i=row1; i<=row2; i++) {
            ans += preSum[i][col2] - (col1 == 0 ? 0 : preSum[i][col1-1]);
        }

        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
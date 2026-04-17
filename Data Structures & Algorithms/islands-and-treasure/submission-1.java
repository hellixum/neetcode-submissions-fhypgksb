class Solution {
    int L = 2147483647;
    int W = -1;
    int T = 0;

    public void islandsAndTreasure(int[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == T) {
                    mNT(grid, i+1, j, 0);
                    mNT(grid, i, j+1, 0);
                    mNT(grid, i-1, j, 0);
                    mNT(grid, i, j-1, 0);
                }
            }
        }
        
    }

    void mNT(int[][] grid, int r, int c, int l) {
        if(r<0 || c<0 || r >= grid.length || c >= grid[r].length || grid[r][c] <= 0) return ;
        
        if(l+1 > grid[r][c]) return;

        grid[r][c] = Math.min(grid[r][c], l+1);
        
        mNT(grid, r+1, c, grid[r][c]);
        mNT(grid, r, c+1, grid[r][c]);
        mNT(grid, r-1, c, grid[r][c]);
        mNT(grid, r, c-1, grid[r][c]);

    }
}

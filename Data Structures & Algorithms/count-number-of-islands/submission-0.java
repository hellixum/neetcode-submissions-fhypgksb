class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    sinkIsland(grid, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    void sinkIsland(char[][] grid, int r, int c) {

        if(r >= grid.length || r < 0 || c >= grid[0].length || c < 0 || grid[r][c] == '0') return;
        
        grid[r][c] = '0';

        sinkIsland(grid, r+1, c);
        sinkIsland(grid, r, c+1);
        sinkIsland(grid, r-1, c);
        sinkIsland(grid, r, c-1);
    }
}

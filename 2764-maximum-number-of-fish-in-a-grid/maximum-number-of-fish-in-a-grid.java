class Solution {

    public static int calculateFishes(int[][]grid,int row,int col,boolean[][] vis,int m,int n)
    {
        if(row < 0 || col >= m || row >= n || col < 0 || grid[row][col] == 0 || vis[row][col] == true)
        {
            return 0;
        }

        vis[row][col] = true;

        int top = calculateFishes(grid,row-1,col,vis,m,n);

        int right = calculateFishes(grid,row,col+1,vis,m,n);

        int bottom = calculateFishes(grid,row+1,col,vis,m,n);

        int left = calculateFishes(grid,row,col-1,vis,m,n);

        return grid[row][col] + top + right + bottom + left;

    }
    public int findMaxFish(int[][] grid) {

        int m = grid[0].length;
        int n = grid.length;

        int maxFishes = 0;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(grid[i][j] != 0 && vis[i][j] == false)
                {
                    int currFishes = calculateFishes(grid,i,j,vis,m,n);

                    maxFishes = Math.max(maxFishes,currFishes);
                }
            }
        }

        return maxFishes;
        
    }
}
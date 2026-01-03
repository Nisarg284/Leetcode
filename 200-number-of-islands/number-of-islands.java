class Solution {

    public static void helper(char[][] grid,int row,int col,boolean[][]vis,int n,int m)
    {
        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == '0' || vis[row][col])
        {
            return;
        }


        vis[row][col] = true;
        helper(grid,row-1,col,vis,n,m);
        helper(grid,row,col+1,vis,n,m);
        helper(grid,row+1,col,vis,n,m);
        helper(grid,row,col-1,vis,n,m);
        // vis[row][col] = false;

    }

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        int count = 0;

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(grid[i][j] == '1' && !vis[i][j])
                {
                    count++;
                    helper(grid,i,j,vis,n,m);
                }
            }
        }

        return count;
        
    }
}
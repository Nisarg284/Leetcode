class Solution {

    public static void dfsUtil(char[][] grid,int row,int col,boolean[][] vis,int m,int n)
    {
        if(row < 0 || col >= m || row >= n || col < 0 || grid[row][col] == '0' || vis[row][col] == true)
        {
            return;
        }

        vis[row][col] = true;

        // Top
        dfsUtil(grid,row-1,col,vis,m,n);

        // right
        dfsUtil(grid,row,col+1,vis,m,n);

        // bottom
        dfsUtil(grid,row+1,col,vis,m,n);

        // left
        dfsUtil(grid,row,col-1,vis,m,n);

    }
    public int numIslands(char[][] grid) {


        int n = grid.length;
        int m = grid[0].length;

        int islandCount = 0;

        boolean[][] vis = new boolean[n][m];

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(grid[i][j] == '1' && vis[i][j] == false)
                {
                    islandCount++;
                    dfsUtil(grid,i,j,vis,m,n);
                }
            }
        }

        return islandCount;
        
    }
}
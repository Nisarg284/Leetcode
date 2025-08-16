class Solution {

    public static void dfsHelper(char[][]grid,int row,int col,boolean[][]vis,int[][]dir,int n,int m)
    {
        vis[row][col] = true;

        for(int[] d : dir)
        {
            int newRow = row + d[0];
            int newCol = col + d[1];

            if( newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] != '0' && !vis[newRow][newCol])
            {
                dfsHelper(grid,newRow,newCol,vis,dir,n,m);
            }
        }
    }
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

        int count = 0;

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(grid[i][j] == '1' && !vis[i][j])
                {
                    count++;
                    dfsHelper(grid,i,j,vis,dir,n,m);
                }
            }
        }

        return count;
        
    }
}
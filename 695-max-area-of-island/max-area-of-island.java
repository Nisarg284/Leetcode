class Solution {

    public static int findArea(int[][]grid,int row,int col,boolean[][]vis,int m,int n)
    {
        if(row  < 0 || col >= m || row >= n || col < 0 || grid[row][col] == 0 || vis[row][col] == true)
        {
            return 0;
        }


        vis[row][col] = true;

        int top = findArea(grid,row-1,col,vis,m,n);
        int right = findArea(grid,row,col+1,vis,m,n);
        int bottom = findArea(grid,row+1,col,vis,m,n);
        int left = findArea(grid,row,col-1,vis,m,n);


        return 1 + top + right + bottom + left;
    }
    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }


        int maxArea = 0;
        int m = grid[0].length;
        int n = grid.length;

        boolean[][] vis = new boolean[n][m]; 
        
        for(int i = 0;i<n;i++)
        {
            // System.out.println(i);
            for(int j = 0;j<m;j++)
            {
                // System.out.println(j);
                if( grid[i][j] == 1 && vis[i][j] == false )
                {
                    int currArea = findArea(grid,i,j,vis,m,n);
                    maxArea = Math.max(maxArea,currArea);
                }
            }
        }

        return maxArea;
        
    }
}


class Solution {

    public static int findPerimeter(int[][] grid,int row,int col,boolean[][]vis,int m,int n)
    {
        if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == 0 || vis[row][col] == true)
        {
            return 0;
        }

        int currPeri = 0;
        vis[row][col] = true;

        // if(row == 0)
        // {
        //     currPeri++;
        // }

        // if(col == 0)
        // {
        //     currPeri++;
        // }



        if( row == 0 || grid[row-1][col] == 0 )
        {
            currPeri++;
        }

        if( col == 0 || grid[row][col-1] == 0 )
        {
            currPeri++;
        }

        if(row == n-1 || grid[row+1][col] == 0)
        {
            currPeri++;
        }

        if(col == m-1 || grid[row][col+1] == 0)
        {
            currPeri++;
        }


        int top = findPerimeter(grid,row-1,col,vis,m,n);

        int right = findPerimeter(grid,row,col+1,vis,m,n);

        int bottom = findPerimeter(grid,row+1,col,vis,m,n);

        int left = findPerimeter(grid,row,col-1,vis,m,n);

        return currPeri + top + right + bottom + left;
    }
    public int islandPerimeter(int[][] grid) {


        int m = grid[0].length;
        int n = grid.length;

        boolean[][] vis = new boolean[n][m];

        int row;
        int col;
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(grid[i][j] == 1)
                {
                    return findPerimeter(grid,i,j,vis,m,n);
                }
                
            }
        }


        return -1;
        
    }
}
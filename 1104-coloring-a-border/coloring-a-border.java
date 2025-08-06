class Solution {

    public static void dfsHelper(int[][] grid, int row, int col, int newColor,int originalCLR,boolean[][]vis,int[][]dir,int n,int m)
    {
        boolean isBorder = false;
        vis[row][col] = true;

        for(int[] d : dir)
        {
            int newRow = row + d[0];
            int newCol = col + d[1];

            if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= m || (grid[newRow][newCol] != originalCLR && grid[newRow][newCol] >= 1))
            {
                // grid[row][col] = newColor;
                isBorder = true;
            }else if(!vis[newRow][newCol]){
                dfsHelper(grid,newRow,newCol,newColor,originalCLR,vis,dir,n,m);
            }
        }



        if(isBorder)
        {
            grid[row][col] = -1;
        }

    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
    
        int n = grid.length;
        int m = grid[0].length;

        int originalCLR = grid[row][col];
        boolean[][] vis = new boolean[n][m];
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

        dfsHelper(grid,row,col,color,originalCLR,vis,dir,n,m);

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(grid[i][j] == -1)
                {
                    grid[i][j] = color;
                }
            }
        }

        return grid;
    }
}
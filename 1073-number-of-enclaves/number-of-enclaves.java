class Solution {

    public static int dfsHelper(int[][]grid,int row,int col,int n,int m,boolean[][]vis,boolean[] flag)
    {
        if(row  < 0 || col < 0 || row > n-1 || col > m-1 || grid[row][col] == 0 || vis[row][col])
        {
            // flag[0] = true;
            return 0;
        }

        if(row == 0 || col == 0 || row == n-1 || col == m-1)
        {
            flag[0] = true;
        }

        vis[row][col] = true;

        int top = dfsHelper(grid,row-1,col,n,m,vis,flag);
        int right = dfsHelper(grid,row,col+1,n,m,vis,flag);
        int bottom = dfsHelper(grid,row+1,col,n,m,vis,flag);
        int left = dfsHelper(grid,row,col-1,n,m,vis,flag);

        return 1 + top + right + bottom + left;
    }
    public int numEnclaves(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int count = 0;

        for(int i = 1;i<n-1;i++)
        {
            for(int j = 1;j<m-1;j++)
            {
                boolean[] flag = {false};
                if(grid[i][j] == 1 && !vis[i][j])
                {
                    System.out.println("Row : "+i + " col : "+ j);
                    int blocks =  dfsHelper(grid,i,j,n,m,vis,flag);
                    if(!flag[0])
                    {
                        count += blocks;
                    }
                }
            }
        }

        return count;
    }
}
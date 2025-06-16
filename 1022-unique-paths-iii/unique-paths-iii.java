class Solution {

    public static void findStart(int[][]grid,int m,int n,int[]start)
    {
        
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(grid[i][j] == 1)
                {
                    start[0] = i;
                    start[1] = j;
                }

                if(grid[i][j] == 0)
                {
                    start[2]++;
                }
            }
        }
    }


    public static int dfsHelper(int[][]grid,int row,int col,int safe,int m,int n,boolean[][] vis,int[][] dir)
    {
        if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == -1 || vis[row][col] == true)
        {
            return 0;
        }

        vis[row][col] = true;

        // System.out.println("Row: "+row+", col: "+col);

        
        if(grid[row][col] == 2)
        {
            vis[row][col] = false;
            if(safe == -1)
            {   
                return 1;
            }
            return 0;
        }

        // int paths = 0;

        // for(int[] d : dir )
        // {
        //     int rowIdx = row + d[0];
        //     int colIdx = col + d[1];

        //     if(rowIdx < 0 || colIdx < 0 || rowIdx >= n || colIdx >= m )
        //     {
        //         vis[rowIdx][colIdx] = true;
        //         paths+=dfsHelper(grid,rowIdx,colIdx,safe-1,m,n,vis,dir); 
        //         vis[rowIdx][colIdx] = false;
        //     }

            
        // }

        // // vis[row][col] = false;

        // return paths;


        vis[row][col] = true;
        int top = dfsHelper(grid,row-1,col,safe-1,m,n,vis,dir);
        int right = dfsHelper(grid,row,col+1,safe-1,m,n,vis,dir);
        int bottom = dfsHelper(grid,row+1,col,safe-1,m,n,vis,dir);
        int left = dfsHelper(grid,row,col-1,safe-1,m,n,vis,dir);
        vis[row][col] = false;

        return top + right + bottom + left;


    }
    public int uniquePathsIII(int[][] grid) {

        int m = grid[0].length;
        int n = grid.length;

        boolean[][] vis = new boolean[n][m];

        int start[] = new int[3];
        findStart(grid,m,n,start);

        int startRow = start[0];
        int startCol = start[1];
        int safe = start[2] ;

        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

        return dfsHelper(grid,startRow,startCol,safe,m,n,vis,dir);
        
    }
}


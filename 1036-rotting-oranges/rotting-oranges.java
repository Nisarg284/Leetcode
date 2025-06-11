class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid[0].length;
        int n = grid.length;


        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        int freshOrg = 0;

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new int[]{i,j});
                    vis[i][j] = true;
                }

                if(grid[i][j] == 1)
                {
                    freshOrg++;
                }

            }
        }

        if(freshOrg == 0)
        {
            return 0;
        }

        

        // vis[q.peek()[0]][q.peek()[1]] = true;
        int time = 0;
        // boolean flag = false;

        while(!q.isEmpty())
        {

            int size = q.size();
            boolean flag = false;

            for(int i = 0;i<size;i++)
            {
                int[] currArr = q.remove();

                int row = currArr[0];
                int col = currArr[1];

                if(row > 0 && grid[row-1][col] == 1 && vis[row-1][col] == false)
                {
                    q.add(new int[]{row-1,col});
                    vis[row-1][col] = true;
                    freshOrg--;
                    flag = true;
                    // grid[row-1][col] = 2;
                }

                if(row < n-1 && grid[row+1][col] == 1 && vis[row+1][col] == false)
                {
                    q.add(new int[]{row+1,col});
                    vis[row+1][col] = true;
                    freshOrg--;
                    flag =true;
                    //  grid[row-1][col] = 2;
                }

                if(col > 0 && grid[row][col-1] == 1 && vis[row][col-1] == false)
                {
                    q.add(new int[]{row,col-1});
                    vis[row][col-1] = true;
                    freshOrg--;
                    flag =true;
                    //  grid[row-1][col] = 2;
                }

                if(col < m-1 && grid[row][col+1] == 1 && vis[row][col+1] == false)
                {
                    q.add(new int[]{row,col+1});
                    vis[row][col+1] = true;
                    freshOrg--;
                    flag =true;
                    //  grid[row-1][col] = 2;
                }
            }
            if(flag)
            {
                time++;
            }
        }


        // for(int i = 0;i<n;i++)
        // {
        //     for(int j = 0;j<m;j++)
        //     {
        //         if(grid[i][j] == 1 && vis[i][j] == false)
        //         {
        //             return -1;
        //         }
        //     }
        // }


        return freshOrg == 0?time:-1;


        
    }
}
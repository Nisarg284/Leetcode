class Solution {


    public void helper(Queue<int[]>q,char[][]grid,boolean[][]vis,int n,int m)
    {
        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0;i<size;i++)
            {
                int[] curr = q.remove();

                int currRow = curr[0];
                int currCol = curr[1];

                if(currRow - 1 >= 0 && grid[currRow-1][currCol] == '1' && !vis[currRow-1][currCol])
                {
                    vis[currRow-1][currCol] = true;
                    q.add(new int[]{currRow-1,currCol});
                }


                if(currCol+1 < m && grid[currRow][currCol+1] == '1' && !vis[currRow][currCol+1])
                {
                    vis[currRow][currCol+1] = true;
                    q.add(new int[]{currRow,currCol+1});
                }

                if(currRow + 1 < n && grid[currRow+1][currCol] == '1' && !vis[currRow+1][currCol])
                {
                    vis[currRow+1][currCol] = true;
                    q.add(new int[]{currRow+1,currCol});
                }


                if(currCol -1 >= 0 && grid[currRow][currCol-1] == '1' && !vis[currRow][currCol-1])
                {
                    vis[currRow][currCol-1] = true;
                    q.add(new int[]{currRow,currCol-1});
                }
            }
        }
    }

    public int numIslands(char[][] grid) {


        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        int island = 0;

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(grid[i][j] == '1' && !vis[i][j])
                {
                    q.add(new int[]{i,j});
                    island++;
                    
                    helper(q,grid,vis,n,m);
                }
            }
        }

        return island;
        
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0] == 1)
        {
            return -1;
        }


        int m = grid[0].length;
        int n = grid.length;

        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1},{-1,-1},{-1,1},{1,1},{1,-1}};

        Queue<int[]> q = new LinkedList<>();
        

        boolean[][] vis = new boolean[n][m];
        q.add(new int[]{0,0});
        vis[0][0] = true;


        int dist = 1;
        boolean flag = false;

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0;i<size;i++)
            {
                int[] currArr = q.remove();

                int currRow = currArr[0];
                int currCol = currArr[1];

                if(currRow == n-1 && currCol == m-1)
                {
                    return dist;
                }

                for(int[] d : dir)
                {
                    int row = currRow + d[0];
                    int col = currCol + d[1];

                    if(row >= 0 && row < n && col >= 0 && col < m && vis[row][col] == false && grid[row][col] == 0)
                    {
                        q.add(new int[]{row,col});
                        vis[row][col] = true;
                    }
                }

            }
            dist++;
        }

        return -1;
        

        
    }
}
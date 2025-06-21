
class Solution {

    public static boolean dfsHelper(List<List<Integer>> grid,int row,int col,int n ,int m,boolean[][][]vis,int health,int[][] dir)
    {
        if(row < 0 || col < 0 || row >= n || col >= m || health <= 0 || vis[row][col][health] == true)
        {
            return false;
        }

        vis[row][col][health] = true;

        if(row == n-1 && col == m-1 )
        {

            if(grid.get(row).get(col) == 1)
            {
                health -=1;
            }

            return health >= 1;
            
        }

        boolean curr = false;
        

       for(int[] d : dir)
       {
            int newRow = row + d[0];
            int newCol = col + d[1];
            
            // vis[row][col][health] = true;
            if(newRow >=0 && newCol >= 0 && newRow <n && newCol < m )
            {
                // vis[row][col] = true;
                // if(grid.get(row).get(col)  == 1)
                // {
                //     curr =  curr || dfsHelper(grid,newRow,newCol,n,m,vis,health - 1,dir);
                // }else{
                //     curr =  curr || dfsHelper(grid,newRow,newCol,n,m,vis,health,dir);
                // }

                curr = curr || dfsHelper(grid,newRow,newCol,n,m,vis,health - grid.get(row).get(col),dir);
                // vis[row][col] =false;
            }
            //  vis[row][col] =false;
            
       }

       return curr;
        
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int n = grid.size();
        int m = grid.get(0).size();

        boolean[][][] vis = new boolean[n][m][health+1];
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

        return dfsHelper(grid,0,0,n,m,vis,health,dir);
        
    }
}


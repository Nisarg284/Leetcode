class Solution {


    public static void helper(int i,int j,boolean[][]vis,char[][]grid,int n,int m){

        if(i < 0 || j >= m || i >= n || j < 0 || grid[i][j] == '0' || vis[i][j] == true){
            return;
        }

        vis[i][j] = true;

        // up
        helper(i-1,j,vis,grid,n,m);

        // right
        helper(i,j+1,vis,grid,n,m);

        // down
        helper(i+1,j,vis,grid,n,m);

        // left
        helper(i,j-1,vis,grid,n,m);
    }

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
      
        int count = 0;

        boolean[][] vis = new boolean[n][m];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){

                if(grid[i][j] == '1' && vis[i][j] == false){
                    helper(i,j,vis,grid,n,m);
                    count++;
                }
            }
        }

        return count;


        
    }
}
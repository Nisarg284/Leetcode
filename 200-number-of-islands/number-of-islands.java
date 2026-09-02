class Solution {

    public static void helper(int i,int j,char[][]grid,boolean[][]vis,int n,int m){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0' || vis[i][j]){
            return;
        }
        vis[i][j] = true;

        // top
        helper(i-1,j,grid,vis,n,m);
        // right
        helper(i,j+1,grid,vis,n,m);
        // down
        helper(i+1,j,grid,vis,n,m);
        // left
        helper(i,j-1,grid,vis,n,m);
    }
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        int count = 0;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    count++;
                    helper(i,j,grid,vis,n,m);
                }
            }
        }

        return count;

        
    }
}
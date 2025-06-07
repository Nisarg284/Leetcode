class Solution {

    public static void dfsHelper(int[][] grid,int row,int col,int newColor,int prevColor,boolean[][] vis,int m,int n)
    {
        if(row < 0 || col < 0 || row>= n || col >= m || grid[row][col] != prevColor || vis[row][col] == true)
        {
            return;
        }

        // vis[row][col] = true;
        if(grid[row][col] == prevColor)
        {
            vis[row][col] = true;
            grid[row][col] = newColor;

            // top
            dfsHelper(grid,row-1,col,newColor,prevColor,vis,m,n);

            // right
            dfsHelper(grid,row,col+1,newColor,prevColor,vis,m,n);

            //bottom
            dfsHelper(grid,row+1,col,newColor,prevColor,vis,m,n);

            // left
            dfsHelper(grid,row,col-1,newColor,prevColor,vis,m,n);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int m = image[0].length;
        int n = image.length;

        boolean [][] vis = new boolean[n][m];
        int prevColor = image[sr][sc];

        dfsHelper(image,sr,sc,color,prevColor,vis,m,n);

        return image;
        
    }
}
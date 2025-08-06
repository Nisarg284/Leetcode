class Solution {


//     public static boolean dfsHelper(int[][] grid, int row, int col, int newColor,int originalClr,boolean[][]vis,int n,int m)
//     {
//         if(row < 0 || col < 0 || row > n-1 || col > m-1 || vis[row][col])
//         {
//             return false;
//         }
//         vis[row][col] = true;

//         if(grid[row][col] != originalClr)
//         {
//             // vis[row][col] = true;
//             return true;
//         }
//         // vis[row][col] = true;

       


//         boolean top = dfsHelper(grid,row-1,col,newColor,originalClr,vis,n,m);
//         boolean right = dfsHelper(grid,row,col+1,newColor,originalClr,vis,n,m);
//         boolean bottom = dfsHelper(grid,row+1,col,newColor,originalClr,vis,n,m);
//         boolean left = dfsHelper(grid,row,col-1,newColor,originalClr,vis,n,m);

//         if(top || right || bottom || left)
//         {
//             grid[row][col] = newColor;
//             return true;
//         }

//         return false;
//     }
    public int[][] colorBorder(int[][] grid, int row, int col, int newColor) {

        int n = grid.length;
        int m = grid[0].length;

        int originalClr = grid[row][col];

        boolean[][] vis = new boolean[n][m];

        dfsHelper(grid,row,col,newColor,originalClr,vis,n,m);


        return grid;
        
    }



public static boolean dfsHelper(int[][] grid, int row, int col, int newColor, int originalClr, boolean[][] vis, int n, int m) {
    if(row < 0 || col < 0 || row >= n || col >= m) {
        return true; // Out of bounds, so current cell is border
    }
    
    if(vis[row][col]) return false;

    if(grid[row][col] != originalClr) {
        return true; // Neighboring cell is different, so current cell is border
    }

    vis[row][col] = true;

    boolean isBorder = false;

    if (dfsHelper(grid, row - 1, col, newColor, originalClr, vis, n, m)) isBorder = true;
    if (dfsHelper(grid, row + 1, col, newColor, originalClr, vis, n, m)) isBorder = true;
    if (dfsHelper(grid, row, col - 1, newColor, originalClr, vis, n, m)) isBorder = true;
    if (dfsHelper(grid, row, col + 1, newColor, originalClr, vis, n, m)) isBorder = true;

    if (isBorder) {
        grid[row][col] = newColor;
    }

    return false; // The current cell is not the border
}
}


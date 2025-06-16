// class Solution {

//     public static void findStart(int[][]grid,int m,int n,int[]start)
//     {
        
//         for(int i = 0;i<n;i++)
//         {
//             for(int j = 0;j<m;j++)
//             {
//                 if(grid[i][j] == 1)
//                 {
//                     start[0] = i;
//                     start[1] = j;
//                 }

//                 if(grid[i][j] == 0)
//                 {
//                     start[2]++;
//                 }
//             }
//         }
//     }


//     public static int dfsHelper(int[][]grid,int row,int col,int safe,int m,int n,boolean[][] vis,int[][] dir)
//     {
//         if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == -1 || vis[row][col] == true)
//         {
//             return 0;
//         }

//         vis[row][col] = true;

//         System.out.println("Row: "+row+", col: "+col);

        
//         if(grid[row][col] == 2)
//         {
//             vis[row][col] = false;
//             if(safe == 0)
//             {
                
//                 System.out.println("founded");
//                 return 1;
//             }
//             return 0;
//         }

//         // int paths = 0;

//         // for(int[] d : dir )
//         // {
//         //     int rowIdx = row + d[0];
//         //     int colIdx = col + d[1];

//         //     if(rowIdx < 0 || colIdx < 0 || rowIdx >= n || colIdx >= m )
//         //     {
//         //         vis[rowIdx][colIdx] = true;
//         //         paths+=dfsHelper(grid,rowIdx,colIdx,safe-1,m,n,vis,dir); 
//         //         vis[rowIdx][colIdx] = false;
//         //     }

            
//         // }

//         // // vis[row][col] = false;

//         // return paths;


//         // vis[row][col] = true;
//         int top = dfsHelper(grid,row-1,col,safe-1,m,n,vis,dir);
//         int right = dfsHelper(grid,row,col+1,safe-1,m,n,vis,dir);
//         int bottom = dfsHelper(grid,row+1,col,safe-1,m,n,vis,dir);
//         int left = dfsHelper(grid,row,col-1,safe-1,m,n,vis,dir);
//         vis[row][col] = false;

//         return top + right + bottom + left;


//     }
//     public int uniquePathsIII(int[][] grid) {

//         int m = grid[0].length;
//         int n = grid.length;

//         boolean[][] vis = new boolean[n][m];

//         int start[] = new int[3];
//         findStart(grid,m,n,start);

//         int startRow = start[0];
//         int startCol = start[1];
//         int safe = start[2] ;

//         // System.out.println("startRow: "+startRow+", startCol: "+startCol+", safe Block:"+ safe);

//         int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

//         return dfsHelper(grid,startRow,startCol,safe,m,n,vis,dir);



//         // return 0;




        
//     }
// }


class Solution {
    public static void findStart(int[][] grid, int m, int n, int[] start) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                    start[2]++; // Count starting cell as a cell to visit
                } else if (grid[i][j] == 0) {
                    start[2]++; // Count empty cells
                }
            }
        }
    }

    public static int dfsHelper(int[][] grid, int row, int col, int safe, int m, int n, boolean[][] vis, int[][] dir) {
        // Base case: out of bounds, obstacle, or already visited
        if (row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == -1 || vis[row][col]) {
            return 0;
        }

        // Mark current cell as visited
        vis[row][col] = true;

        // Base case: reached end point
        if (grid[row][col] == 2) {
            if (safe == 0) {
                vis[row][col] = false; // Backtrack
                return 1; // Valid path found
            }
            vis[row][col] = false; // Backtrack
            return 0; // Not a valid path
        }

        // Explore all four directions
        int paths = 0;
        for (int[] d : dir) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            paths += dfsHelper(grid, newRow, newCol, safe - 1, m, n, vis, dir);
        }

        // Backtrack: unmark current cell
        vis[row][col] = false;

        return paths;
    }

    public int uniquePathsIII(int[][] grid) {
        int m = grid[0].length; // Columns
        int n = grid.length; // Rows

        boolean[][] vis = new boolean[n][m];
        int[] start = new int[3]; // start[0]: row, start[1]: col, start[2]: safe cells
        findStart(grid, m, n, start);

        int startRow = start[0];
        int startCol = start[1];
        int safe = start[2]; // Number of cells to visit (including start)

        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // Up, right, down, left

        // Mark starting cell as visited
        // vis[startRow][startCol] = true;
        return dfsHelper(grid, startRow, startCol, safe , m, n, vis, dir);
    }
}
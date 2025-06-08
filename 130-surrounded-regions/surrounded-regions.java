// class Solution {

//     public static void dfsHelper(char[][] grid,int row,int col,boolean[][] vis,boolean[]flag,int m,int n)
//     {
//         if(row < 0 || col < 0 || col >= m || row >= n || grid[row][col] == 'X' || vis[row][col] == true)
//         {
//             return;
//         }

//         vis[row][col] = true;
//         if(row == 0 || col == 0 || row == n-1 || col == m-1)
//         {
//             flag[0] = true;
//             // return;
//         }

//         // if(flag[0] == true)
//         // {
//         //     return;
//         // }

//         // top
//         dfsHelper(grid,row-1,col,vis,flag,m,n);

//         // right
//         dfsHelper(grid,row,col+1,vis,flag,m,n);

//         // bottom
//         dfsHelper(grid,row+1,col,vis,flag,m,n);

//         // left
//         dfsHelper(grid,row,col-1,vis,flag,m,n);

//         //  if(row == 0 || col == 0 || row == n-1 || col == m-1)
//         // {
//         //     flag[0] = true;
//         //     return;
//         // }

//         if(flag[0] == true)
//         {
//             return;
//         }

//         // if(flag[0] == true)
//         // {
//         //     return;
//         // }


//             System.out.println("Row: "+row +" col: "+col);

//             // if(flag[0] == false)
//             // {
//                 grid[row][col] = 'X';
//             // }
        
//             // grid[row][col] = 'X';
//         // }


//     }
//     public void solve(char[][] board) {

//         int m = board[0].length;
//         int n = board.length;

//         boolean vis[][] = new boolean[n][m];

//         for(int i = 0;i<n;i++)
//         {
//             for(int j = 0;j<m;j++)
//             {
//                 if(board[i][j] == 'O' && vis[i][j] == false)
//                 {
//                     boolean[] flag = new boolean[1];
//                     dfsHelper(board,i,j,vis,flag,m,n);
//                 }
//             }
//         }


        
        
//     }
// }


class Solution {

    public static void dfsHelper(char[][] board, int row, int col, boolean[][] vis, boolean[] flag, List<int[]> region, int n, int m) {
        if (row < 0 || col < 0 || row >= n || col >= m || board[row][col] != 'O' || vis[row][col])
            return;

        vis[row][col] = true;
        region.add(new int[]{row, col});

        if (row == 0 || col == 0 || row == n - 1 || col == m - 1)
        {
            flag[0] = true;
        }
            

        // top
        dfsHelper(board, row - 1, col, vis, flag, region, n, m);

        // right
        dfsHelper(board, row, col + 1, vis, flag, region, n, m);

        // bottom
        dfsHelper(board, row + 1, col, vis, flag, region, n, m);

        // left
        dfsHelper(board, row, col - 1, vis, flag, region, n, m);
       
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < m; j++) 
            {
                if (board[i][j] == 'O' && !vis[i][j]) 
                {
                    boolean[] flag = new boolean[1];
                    List<int[]> region = new ArrayList<>();

                    dfsHelper(board, i, j, vis, flag, region, n, m);

                    if (!flag[0]) 
                    {
                        for (int[] arr : region) 
                        {
                            board[arr[0]][arr[1]] = 'X';
                        }
                    }
                }
            }
        }
    }
}

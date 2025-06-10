class Solution {


    public static boolean dfsHelper(char[][]grid,int row,int col,String word,int idx,int len,boolean[][] vis,int m,int n)
    {
        if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] != word.charAt(idx) || vis[row][col] == true || idx >= len )
        {
            return false;
        }

        vis[row][col] = true;

        if(idx == len-1)
        {
            return true;
        }


        boolean top = dfsHelper(grid,row-1,col,word,idx+1,len,vis,m,n);

        boolean right = dfsHelper(grid,row,col+1,word,idx+1,len,vis,m,n);

        boolean bottom = dfsHelper(grid,row+1,col,word,idx+1,len,vis,m,n);

        boolean left = dfsHelper(grid,row,col-1,word,idx+1,len,vis,m,n);

        vis[row][col] = false;

        return top || right || bottom || left;
    }
    public boolean exist(char[][] board, String word) {

        int m = board[0].length;
        int n = board.length;

        boolean[][] vis = new boolean[n][m];

        int idx = 0;
        int len = word.length();

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(board[i][j] == word.charAt(0) && dfsHelper(board,i,j,word,idx,len,vis,m,n))
                {
                    return true;
                    
                }
            }
        }

        return false;
        
    }
}
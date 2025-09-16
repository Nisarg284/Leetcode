class Solution {

    public static boolean isValid(int row,int col,boolean[][] vis,int n)
    {
        // top
        for(int i = 0;i<row;i++)
        {
            if(vis[i][col])
            {
                return false;
            }
        }

        // left top diagonal
        for(int i = row - 1,j = col -1;i >= 0 && j >= 0;i--,j--)
        {
            if(vis[i][j])
            {
                return false;
            }
        }

        // right top diagonal
        for(int i = row-1,j = col+1;i>=0 && j<n;i--,j++)
        {
            if(vis[i][j])
            {
                return false;
            }
        }

        return true;
    }

    public static int nQueens(int placedQueen,int n,boolean[][]vis)
    {
        if(placedQueen == n)
        {
            return 1;
        }

        int count = 0;

        for(int i = 0;i<n;i++)
        {
            if(isValid(placedQueen,i,vis,n))
            {
                vis[placedQueen][i] = true;
                count += nQueens(placedQueen + 1,n,vis);
                vis[placedQueen][i] = false;
            }
        }

        return count;

    }
    public int totalNQueens(int n) {

        int placedQueen = 0;
        boolean[][] vis = new boolean[n][n];

        return nQueens(placedQueen,n,vis);

        
    }
}
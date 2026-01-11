class Solution {

    public void helper(int row,int col,int prevHeight,int[][]heights,int n,int m,boolean[][]vis)
    {
        if(row < 0 || col < 0 || row >= n || col >= m || vis[row][col] == true || heights[row][col] < prevHeight)
        {
            return;
        }

        vis[row][col] = true;

        // up
        helper(row-1,col,heights[row][col],heights,n,m,vis);

        // right
        helper(row,col+1,heights[row][col],heights,n,m,vis);

        // down
        helper(row+1,col,heights[row][col],heights,n,m,vis);

        // left
        helper(row,col-1,heights[row][col],heights,n,m,vis);



        
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int row = 0;
        int col = 0;

        int n = heights.length;
        int m = heights[0].length;

        boolean[][]vis1 = new boolean[n][m];
        boolean[][]vis2 = new boolean[n][m];


        for(int i = 0;i<m;i++)
        {
            // first row
            // Pacific Ocean
            helper(0,i,-1,heights,n,m,vis1);
            // // first col
            // helper(i,0,-1,heights,n,m,vis);

            // last row
            // Atlantic Ocean
            helper(n-1,i,-1,heights,n,m,vis2);
        }

        for(int i = 0;i<n;i++)
        {
            // first col
            // Pacific Ocean
            helper(i,0,-1,heights,n,m,vis1);

            // last col
            // Atlantic Ocean
            helper(i,m-1,-1,heights,n,m,vis2);
        }


        List<List<Integer>> ans = new ArrayList<>();


        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(vis1[i][j] == true && vis2[i][j] == true)
                {
                    ans.add(new ArrayList<>(List.of(i,j)));
                }
            }
        }
        return ans;
        
    }
}
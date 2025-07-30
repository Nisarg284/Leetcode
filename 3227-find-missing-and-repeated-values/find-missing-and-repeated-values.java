class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        HashSet<Integer> hs = new HashSet<>();

        int n = grid.length;
        int m =grid[0].length;

        int [] ans = new int[2];

        boolean flag = false;

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(hs.contains(grid[i][j]))
                {
                    ans[0] = grid[i][j];
                    // flag = true;
                    // break;
                }

                hs.add(grid[i][j]);

            }


            // if(flag == true)
            // {
            //     break;
            // }
        }


        for(int i = 1;i<=n*n;i++)
        {
            if(!hs.contains(i))
            {
                ans[1] = i;
                break;
            }
        }

        return ans;
        
    }
}
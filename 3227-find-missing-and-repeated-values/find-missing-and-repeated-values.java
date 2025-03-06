class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

       HashSet<Integer> hs = new HashSet<>();
        int max = Integer.MIN_VALUE;

        int ans[] = new int[2];

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(hs.contains(grid[i][j]))
                {
                    ans[0] = grid[i][j];
                }
                hs.add(grid[i][j]); 
            }
        }

        int missing = -1;
        int i =1;
        while(true)
        {
            if(!hs.contains(i))
            {
                ans[1] = i;
                break;
            }
            i++;
        }

        return ans;
         
        
    }
}
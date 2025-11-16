class Solution {

    public static int helper(int i,int j,int lower,int upper,int[]cuts,int[][]dp)
    {
        if(i > j)
        {
            return 0;
        }

        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }

        int minCost = Integer.MAX_VALUE;

        for(int k = i;k<=j;k++)
        {
            // System.out.println("upper: "+upper+", lower: "+ lower);
           int currCost = (upper - lower) 
           + helper(i,k-1,lower,cuts[k],cuts,dp) 
           + helper(k+1,j,cuts[k],upper,cuts,dp);

           minCost = Math.min(minCost,currCost);
        }

        return dp[i][j] = minCost;
    }
    public int minCost(int n, int[] cuts) {


        int i = 0;
        int j = cuts.length-1;

        int lower = 0;
        int upper = n;

        Arrays.sort(cuts);

        int len = cuts.length;


        int[][]dp = new int[len][len];

        for(int[]a : dp)
        {
            Arrays.fill(a,-1);
        }

        return helper(i,j,lower,upper,cuts,dp);
        
    }
}
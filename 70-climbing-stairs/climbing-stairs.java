class Solution {

    public static int helper(int n,int[]memo)
    {
        if(n < 0)
        {
            return 0;
        }

        if(memo[n] != -1)
        {
            return memo[n];
        }

        int oneStep = helper(n-1,memo);
        int twoStep = helper(n-2,memo);

        

        return memo[n] = oneStep + twoStep;
    }
    public int climbStairs(int n) {


        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        memo[0] = 1;
        memo[1] = 1;

        return helper(n,memo);
        
    }
}
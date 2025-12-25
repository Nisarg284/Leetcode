class Solution {

    public int helper(int n,int[]memo)
    {
        if(n <= 2)
        {
            return n;
        }

        if(memo[n] != -1)
        {
            return memo[n];
        }

        return memo[n] = helper(n-1,memo) + helper(n-2,memo); 
    }
    public int climbStairs(int n) {

        int[] memo = new int[n+1];

        Arrays.fill(memo,-1);

        return helper(n,memo);
    }
}
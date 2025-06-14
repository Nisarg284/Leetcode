class Solution {

    public static int helper(int n ,int[]memo)
    {
       if(n==0 || n== 1)
        {
            return n;
        }

        if( n==2 )
        {
            return 1;
        }

        if(memo[n] != 0)
        {
            return memo[n];
        } 


        int first = helper(n-1,memo);
        int sec = helper(n-2,memo);
        int third = helper(n-3,memo);

        memo[n] = first + sec + third;

        return memo[n];
    }
    public int tribonacci(int n) {

        if(n==0 || n== 1)
        {
            return n;
        }

        if( n==2 )
        {
            return 1;
        }
    

        int[] memo = new int[n+1];

        return helper(n,memo);


    }
}
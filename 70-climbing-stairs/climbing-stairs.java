class Solution {

    // public static int helper(int n,HashMap<Integer,Integer>hm)
    // {
    //     // Base Case:
    //     if(n==1 || n== 2)
    //     {
    //         return n;
    //     }

    //     if(!hm.containsKey(n))
    //     {
    //         hm.put(n,helper(n-1,hm)+helper(n-2,hm)); 
    //     }
    //     int ans = hm.get(n);
    //     return ans;

    // }
    // public int climbStairs(int n) {

    // //   HashMap<Integer,Integer> hm = new HashMap<>();

    // // if(n == 1 || n == 2)
    // // {
    // //     return n;
    // // }


    // int[] dp = new int[n+1];

    // dp[0] = 1;
    // dp[1] = 1;

    // for(int i = 2;i<dp.length;i++)
    // {
    //     dp[i] = dp[i-1] + dp[i-2];
    // }

    // return dp[dp.length-1];
    // //   return climbStairs(n-1) + climbStairs(n-2);


        
    // }


    public static int helper(int n,int[]dp)
    {
        if(n == 0 || n == 1)
        {
            return 1;
        }

        if(dp[n] != -1)
        {
            return dp[n];
        }

        dp[n] = helper(n-1,dp) + helper(n-2,dp);

        return dp[n];
    }

    public int climbStairs(int n){
        // if(n == 1 || n == 2)
        // {
        //     return n;
        // }

        int[] dp = new int[n+1];

        for(int i = 0;i<=n;i++)
        {
            dp[i] = -1;
        }
        

        return helper(n,dp);
    }

}

// 5 = 1 1 1 1 1
//     1 2 2
//     1 2 1 1
//     2 1 1 1
//     2 2 1
//     2 1 2
//     1 1 1 2
//     1 1 2 1

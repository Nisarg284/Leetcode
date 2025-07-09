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
    public int climbStairs(int n) {

    //   HashMap<Integer,Integer> hm = new HashMap<>();

    // if(n == 1 || n == 2)
    // {
    //     return n;
    // }


    int[] dp = new int[n+1];

    dp[0] = 1;
    dp[1] = 1;

    for(int i = 2;i<dp.length;i++)
    {
        dp[i] = dp[i-1] + dp[i-2];
    }

    return dp[dp.length-1];
    //   return climbStairs(n-1) + climbStairs(n-2);


        
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

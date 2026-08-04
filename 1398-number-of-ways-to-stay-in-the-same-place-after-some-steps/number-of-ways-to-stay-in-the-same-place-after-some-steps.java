class Solution {

    public static int helper(int idx,int steps, int arrLen,int[][]dp){

        if(idx >= arrLen || idx < 0 || (steps == 0 && idx != 0) || steps < 0){
            return 0;
        }

        if(dp[steps][idx] != -1){
            return dp[steps][idx];
        }

        if(idx == 0 && steps == 0){
            return 1;
        }

        


        int mod = 1000000007;

       
        
            // System.out.print(" right ");
            int moveRight = helper(idx + 1,steps - 1,arrLen,dp);

            // System.out.print(" stay ");
            int stay = helper(idx ,steps - 1,arrLen,dp);

            // System.out.print(" left ");
            int moveLeft = helper(idx - 1,steps - 1,arrLen,dp);

            long totalWays = ((long)moveRight + stay + moveLeft) % mod;

            // System.out.println();
        


        return dp[steps][idx] = (int) totalWays;
    }
    public int numWays(int steps, int arrLen) {

        int idx = 0;
        int minCol = Math.min(steps,arrLen);

        int[][]dp = new int[steps+1][minCol+1];

        for(int[]arr : dp){
            Arrays.fill(arr,-1);
        }
        return helper(idx,steps,arrLen,dp);
    }
}
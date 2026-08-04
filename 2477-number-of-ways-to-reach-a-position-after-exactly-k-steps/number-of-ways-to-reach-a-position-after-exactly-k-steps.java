class Solution {

    public static int helper(int startPos, int endPos, int k,Map<String,Integer>dp){


        if(startPos == endPos && k == 0){
            return 1;
        }

        if(k == 0 && startPos != endPos){
            return 0;
        }


        String key = startPos+","+k;
         if(dp.get(key) != null){
            return dp.get(key);
        }

        

        

        // if(dp.get(startPos) != null){
        //     return dp.get(startPos);
        // }

        int mod = 1000000007;

        int left = helper(startPos - 1,endPos,k-1,dp);
        int right = helper(startPos + 1,endPos,k-1,dp);

        long ways = (long)(left + right);

        dp.put(key,(int) ways % mod);

        return (int) ways % mod;
    }
    public int numberOfWays(int startPos, int endPos, int k) {

        

        int n = endPos - startPos;

        // int[][]dp = new int[n+1][k+1];
        Map<String,Integer> dp = new HashMap<>();

        // for(int[]arr : dp){
        //     Arrays.fill(arr,-1);
        // }

        return helper(startPos,endPos,k,dp);

        
        
    }
}
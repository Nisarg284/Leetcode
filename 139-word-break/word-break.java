class Solution {


    public boolean helper(int idx,String s,Set<String>hs,Boolean[]dp)
    {
        if(idx == 0)
        {
            return true;
        }

        if(dp[idx] != null)
        {
            return dp[idx];
        }

        for(int i = idx - 1;i>=0;i--)
        {
            String subStr = s.substring(i,idx);
            if(hs.contains(subStr))
            {
                if(helper(i,s,hs,dp))
                {
                    return dp[idx] = true;
                }
            }
        }

        return dp[idx] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String>hs = new HashSet<>();

        wordDict.forEach(
            word -> hs.add(word)
        );


        int n = s.length();

        Boolean[] dp = new Boolean[n+1];
        // System.out.println(dp[0]);

        // return false;

        return helper(n,s,hs,dp);
        
    }
}
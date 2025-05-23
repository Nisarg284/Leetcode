class Solution {
    public int minDistance(String word1, String word2) {

        // length of both string
        int n = word1.length();
        int m = word2.length();

        // create new dp array
        int[][] dp = new int[n+1][m+1];

        // initialize 0th row
        for(int i=0;i<dp[0].length;i++)
        {
            dp[0][i] = i;
        }
        
         // initialize 0th column
        for(int j=0;j<dp.length;j++)
        {
            dp[j][0] = j;
        }


        // fill remaining dp array
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                // if both characters are same
                if(word1.charAt(i-1) == word2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    // if both characters are not same

                    // add
                    int add = dp[i][j-1] + 1;

                    // delete
                    int delete = dp[i-1][j] + 1;

                    //replace
                    int replace = dp[i-1][j-1] + 1;

                    dp[i][j] = Math.min(add,Math.min(delete,replace));
                }
            }
        }

        return dp[n][m];
    }
}
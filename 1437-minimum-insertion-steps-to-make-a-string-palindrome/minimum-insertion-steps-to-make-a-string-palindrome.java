class Solution {

    public static int helper(String s,int i,int j,int[][]dp)
    {
        if(i >= j)
        {
            return 0;
        }

        if(dp[i][j] != 0)
        {
            return dp[i][j];
        }

        if(s.charAt(i) == s.charAt(j))
        {
            return dp[i][j] = helper(s,i+1,j-1,dp);
        }

        return dp[i][j] = 1 + Math.min(helper(s,i+1,j,dp),helper(s,i,j-1,dp));

        // return 1 + Math.min(helper(s, i + 1, j), helper(s, i, j - 1));
    }
    public int minInsertions(String s) {

        int i = 0;
        int j = s.length()-1;

        int[][]dp = new int[501][501];

        return helper(s,i,j,dp);
        
    }
}



// class Solution {

//     public static int helper(String s, int i, int j) {
//         if (i >= j) {
//             return 0;
//         }

//         if (s.charAt(i) == s.charAt(j)) {
//             return helper(s, i + 1, j - 1);
//         }

//         return 1 + Math.min(helper(s, i + 1, j), helper(s, i, j - 1)); // FIXED: changed j+1 to j-1
//     }

//     public int minInsertions(String s) {
//         int i = 0;
//         int j = s.length() - 1;
//         return helper(s, i, j);
//     }
// }

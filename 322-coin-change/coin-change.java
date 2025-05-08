class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = Integer.MAX_VALUE - 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    int accept = dp[i][j - coins[i - 1]];
                    int reject = dp[i - 1][j];

                    if (dp[i][j] != Integer.MAX_VALUE - 1) {
                        dp[i][j] = Math.min(1 + accept, reject);
                    } else {
                        dp[i][j] = reject;
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[n][amount];

    }
}
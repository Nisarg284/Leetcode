class Solution {

    public static int countPaths(int m, int n, int[][] memo) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        if (memo[m][n] != 0) {
            return memo[m][n];
        }
        int up = countPaths(m - 1, n, memo);
        int left = countPaths(m, n - 1, memo);
        
        memo[m][n] = up + left;
        return memo[m][n];
    }

    public int uniquePaths(int m, int n) {

        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] memo = new int[m][n];
        return countPaths(m - 1, n - 1, memo);

    }
}
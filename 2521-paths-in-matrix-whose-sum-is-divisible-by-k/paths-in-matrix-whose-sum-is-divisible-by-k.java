class Solution {

    public static int helper(int i,int j,int sum,int k,int n,int m,int[][]grid,int[][][]dp){
        if(i >= n || j >= m){
            return 0;
        }

        // System.out.print(grid[i][j]+" ");

        if(dp[i][j][sum % k] != -1){
            return dp[i][j][sum % k];
        }

        if(i == n-1 && j == m-1){
            return (sum + grid[i][j]) % k == 0 ? 1 : 0;
        }

        

        int mod = 1000000007;
        int down = helper(i+1,j,(sum + grid[i][j]) % k,k,n,m,grid,dp);
        int right = helper(i,j+1,(sum + grid[i][j]) % k,k,n,m,grid,dp);

        // System.out.println();

        long paths = ((long)(down + right)) % mod;


        return dp[i][j][sum % k] = (int) paths;
    }
    public int numberOfPaths(int[][] grid, int k) {

        int i = 0;
        int j = 0;
        int n = grid.length;
        int m = grid[0].length;

        int[][][]dp = new int[n][m][k+1];

        for(int arr[][] : dp){
            for(int[] brr : arr){
                Arrays.fill(brr,-1);
            }
        }

        int ans = helper(i,j,0,k,n,m,grid,dp);

        // for(int arr[][] : dp){
        //     for(int[] brr : arr){
        //         // Arrays.fill(brr,-1);
        //         for(int l : brr){
        //             System.out.print(l + " ");
        //         }
        //         System.out.println();
        //     }
        //     System.out.println("<--------------------------->");

        // }
        return ans;
        
    }
}
class Solution {

    public static double helper(int row,int col,int n,int k,double [][][]dp ){

        if(row >= n || col >= n || row < 0 || col < 0){
            return 0;
        }

        if(k == 0){
            return 1;
        }

        if(dp[row][col][k] != -1.0){
            return dp[row][col][k];
        }

        double leftMostTop = helper(row-1,col-2,n,k-1,dp);
        double leftTop = helper(row-2,col-1,n,k-1,dp);
        double rightTop = helper(row-2,col+1,n,k-1,dp);
        double rightMostTop = helper(row-1,col+2,n,k-1,dp);
        double rightMostBottom = helper(row+1,col+2,n,k-1,dp);
        double rightBottom = helper(row+2,col+1,n,k-1,dp);
        double leftBottom = helper(row+2,col-1,n,k-1,dp);
        double leftMostBottom = helper(row+1,col-2,n,k-1,dp);

        return dp[row][col][k] = (leftMostTop + leftTop + rightTop + rightMostTop + rightMostBottom + rightBottom + leftBottom + leftMostBottom) / 8.0;
    }
    public double knightProbability(int n, int k, int row, int col) {

        double [][][]dp = new double[n][n][k+1];

        for(double[][]arr : dp){
            for(double[] brr : arr){
                Arrays.fill(brr,-1.0);
            }
        }
        
        return helper(row,col,n,k,dp);
    }
}
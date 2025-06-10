class Solution {
    public int diagonalSum(int[][] mat) {

        int sum = 0;

        for(int i = 0;i<mat.length;i++)
        {
            sum+=mat[i][i];
        }

        // for(int i = mat.length-1,j = 0;i>=0,j<mat.length;i--,j++)
        // {
        //     sum+=mat[i][j];
        // }


        int i = mat.length-1;
        int j = 0;

        while(i >= 0)
        {
            sum+=mat[i][j];
            i--;
            j++;
        }

        int n = mat.length;

        if(n%2 != 0)
        {
            int half = n/2;
            sum-=mat[half][half];
        }

        return sum;
        
    }
}
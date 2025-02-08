class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // print matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j <n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            System.out.println();
        }

        int i = 0, j = n-1;
        int k=0;

        while(k<n)
        {

            while (i<j)
            {
                int temp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = temp;
                i++;
                j--;
            }
            j=n-1;
            i=0;
            k++;
        }
        
    }
}
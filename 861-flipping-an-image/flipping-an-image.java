class Solution {

    public static void reverse(int[][]arr,int row)
    {
        int n = arr.length;
        int start = 0;
        int end = n-1;

        while(start <= end)
        {
            int temp = arr[row][start];
            arr[row][start] = arr[row][end];
            arr[row][end] = temp;

            start++;
            end--;
        }
    }
    public int[][] flipAndInvertImage(int[][] arr) {

        int n = arr.length;

        for(int i = 0;i<n;i++)
        {
            reverse(arr,i);
        }

        for(int i=0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(arr[i][j] == 0)
                {
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = 0;
                }
            }
        }

        return arr;


        
    }
}
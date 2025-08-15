class Solution {

    public static int binarySearch(int[][]arr,int target,int n)
    {
        int i = 0;
        int j = n-1;

        int idx = -1;

        while(i <= j)
        {
            int mid = (i + j) / 2;

            if(arr[mid][1] > target)
            {
                j = mid - 1;
            }else{
                idx = mid;
                i = mid + 1;
            }
        }

        System.out.println("idx : " + idx + " , target : "+target );

        return idx;
    }


    public long maxTaxiEarnings(int n, int[][] rides) {

        // long earning = 0;

        int len = rides.length;

        long[] dp = new long[len];

        Arrays.sort(rides,(a,b) -> a[1] == b[1] ? a[0] - b[0] :  a[1] - b[1]);
        dp[0] = rides[0][2] + (rides[0][1] - rides[0][0]);

        for(int i = 1;i<len;i++)
        {
            int start = rides[i][0];
            int idx = binarySearch(rides,start,len);

            long currEarning =  rides[i][2] + (rides[i][1] - rides[i][0]);

            if(idx != -1)
            {
                currEarning += dp[idx];
            }

            long include = currEarning;
            long exclude = dp[i-1];

            dp[i] = Math.max(include,exclude);
        }



        System.out.println("len : "+len);

        for(int i = 0;i<len;i++)
        {
            System.out.println("i"+(i+1)+" : "+dp[i]);
        }

        return dp[len -1];
    }
}
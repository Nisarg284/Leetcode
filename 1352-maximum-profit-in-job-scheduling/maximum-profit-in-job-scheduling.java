class Solution {

    public static int binarySearch(int[][]arr,int target,int n)
    {
        int i = 0;
        int j = n-1;

        int idx = -1;

        while(i <= j)
        {
            int mid = (i + j) / 2;

            // if(arr[mid][1] == target)
            // {
            //     return mid;
            // }

            if(arr[mid][1] > target)
            {
                j = mid-1;
            }else{
                idx = mid;
                i = mid + 1;
            }
        }

        System.out.println("index : "+idx + " , Target : "+ target);

        return idx;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;
        int[][] arr = new int[n][4]; // s e p i

        // HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i = 0;i<n;i++)
        {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
            arr[i][3] = i;


            // hm.put(endTime[i],i);
        }

        Arrays.sort(arr,(a,b) -> a[1] - b[1]);
        int[] dp = new int[n];
        dp[0] = arr[0][2];

        for(int i = 1;i<n;i++)
        {
            int start = arr[i][0];
            int idx = binarySearch(arr,start,n);

            int exclude = dp[i-1];
            int prevProfit = 0;
            int currProfit = arr[i][2];

            if(idx != -1)
            {
                prevProfit = dp[idx];
            }

            int include = prevProfit + currProfit;

            dp[i] = Math.max(include , exclude);
        }


        return dp[n-1];
        
    }
}
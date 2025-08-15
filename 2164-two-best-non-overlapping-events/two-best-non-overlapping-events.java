class Solution {

    public static int binarySearch(int[][]arr,int target,int n)
    {
        int i = 0;
        int j = n-1;

        int idx = -1;


        while(i<=j)
        {
            int mid = (i+j)/2;
            // System.out.println("mid : "+ mid);

            if(arr[mid][1] < target)
            {
                idx = mid;
                i = mid+1;
            }else{
                j = mid - 1;
            }
        }

        // System.out.println("idx : "+idx+" , target : "+target);
        return idx;
    }
    public int maxTwoEvents(int[][] events) {

        int n = events.length;

        Arrays.sort(events,(a,b) -> Integer.compare(a[1], b[1]));

        int[] dp = new int[n];

        dp[0] = events[0][2];

        for(int i = 1;i<n;i++)
        {
            dp[i] = Math.max(dp[i-1],events[i][2]);
        }

        int ans = dp[n-1];

        for(int i = 1;i<n;i++)
        {
           int start = events[i][0];
           int currValue = events[i][2];
           int idx = binarySearch(events,start,n);


           if(idx != -1)
           {
            // System.out.println(" currValue "+currValue+" + dp[idx] "+dp[idx] +" = "+ (dp[idx] + currValue));
                currValue += dp[idx];
           } 

           int include = currValue;
           int exclude = ans;

           ans = Math.max(include,exclude);
        }


        // for(int i = 0;i<n;i++)
        // {
        //     System.out.println("i"+(i+1)+" : "+dp[i]);
        // }
        return ans;        
    }
}
class Solution {

    public static int binarySearch(List<List<Integer>> offers,int target,int n)
    {
        int i = 0;
        int j = n-1;

        int idx = -1;

        while(i <= j)
        {
            int mid = (i+j)/2;

            if(offers.get(mid).get(1) < target)
            {
                idx = mid;
                i = mid + 1;
            }else{
                j = mid -1;
            }
        }

        return idx;
    }
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {

        int size = offers.size();

        int[]dp = new int[size];

        Collections.sort(offers,(a,b) -> a.get(1)-b.get(1));
        dp[0] = offers.get(0).get(2);

        for(int i = 1;i<size;i++)
        {
            int start = offers.get(i).get(0);
            int idx = binarySearch(offers,start,size);

            int earn = offers.get(i).get(2);

            if(idx != -1)
            {
                earn += dp[idx];
            }

            int include = earn;
            int exclude = dp[i-1];

            dp[i] = Math.max(include,exclude);
        }

        return dp[size - 1];
        
    }
}
class Solution {


    public static boolean isValid(int[]arr,long k,int mid,int n)
    {
        long child = 0;

        for(int i : arr)
        {
           child += i/mid; 
        }

        return child >= k;
    }
    public int maximumCandies(int[] candies, long k) {


        int n = candies.length;


        int start = 1;
        int end = Arrays.stream(candies).max().getAsInt();

        // int ans = 0;

        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(!isValid(candies,k,mid,n))
            {
                
                end = mid-1;
            }else{
                // ans = mid;
                start = mid+1;
            }
        }

        return start-1;

        
    }
}
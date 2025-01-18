class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        long ans1 = 0;
        int n=arr.length;

        for(int i=0;i<n;i++)
        {
            ans1 += Math.abs(arr[i]-brr[i]);
        }

        long ans2 = k;
        Arrays.sort(arr);
        Arrays.sort(brr);

        for(int i=0;i<n;i++)
        {
            ans2 += Math.abs(arr[i]-brr[i]);
        }

        return Math.min(ans1,ans2);
        
    }
}
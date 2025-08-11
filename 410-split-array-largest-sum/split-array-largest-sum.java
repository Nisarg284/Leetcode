class Solution {

    public static boolean isValid(int[]arr,int k,int mid,int n)
    {
        int parts = 1;
        int sum = 0;
        for(int i = 0;i<n;i++)
        {
            if(sum + arr[i] <= mid)
            {
                sum += arr[i];
            }else{
                parts++;
                sum = arr[i];
            }
        }

        return parts<=k;
    }
    public int splitArray(int[] nums, int k) {

        int n = nums.length;

        int i = Arrays.stream(nums).max().getAsInt();
        int j = Arrays.stream(nums).sum(); // using stream API 

        while(i <= j)
        {
            int mid = (i + j) / 2;

            if(isValid(nums,k,mid,n))
            {
                j = mid-1;
            }else{
                i = mid+1;
            }
        }

        return i;
        
    }
}
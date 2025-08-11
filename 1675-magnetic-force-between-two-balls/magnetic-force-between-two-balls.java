class Solution {

    public static boolean isValid(int[]arr,int m,int mid,int n)
    {
        int prev = arr[0];
        int ballsPlaced = 1;

        for(int i = 1;i<n;i++)
        {
            if((arr[i] - prev) >= mid)
            {
                prev = arr[i];
                ballsPlaced++;
            }
        }

        return ballsPlaced >= m;

    }
    public int maxDistance(int[] nums, int m) {

        Arrays.sort(nums);

        int n = nums.length;

        int i = 1;
        int j = nums[n-1] - nums[0];

        while(i <= j)
        {
            int mid = (i + j) / 2;

            if(isValid(nums,m,mid,n))
            {
                i = mid + 1;
            }else
            {
                j = mid - 1;
            }
        }

        return i-1;
        
    }
}
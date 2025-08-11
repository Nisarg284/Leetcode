class Solution {

    public static boolean isValid(int[]nums,int threshold,int mid,int n)
    {
        int sum = 0;

        for(int i = 0;i<n;i++)
        {
            if(nums[i] % mid == 0)
            {
                sum+=(nums[i] / mid);
            }else{
                sum += (nums[i]/mid)+1;
            }

            // sum += (nums[i] + mid - 1) / mid;
        }

        System.out.println(sum);

        return sum <= threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {

        int n = nums.length;

        int i = 1;
        int j = Arrays.stream(nums).max().getAsInt();

        while( i <= j)
        {
            int mid = (i + j) / 2;

            if(isValid(nums,threshold,mid,n))
            {
                j = mid-1;
            }else{
                i = mid+1;
            }
        }

        return i;
        
    }
}
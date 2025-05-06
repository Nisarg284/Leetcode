class Solution {
    public int findPeakElement(int[] nums) {
        // int left = 0, right = nums.length - 1;

        // while (left < right) {
        //     int mid = (left + right) / 2;

        //     if (nums[mid] > nums[mid + 1]) {
        //         right = mid; // Peak is on the left or at mid
        //     } else {
        //         left = mid + 1; // Peak is on the right
        //     }
        // }
        // return left; // Left and right converge at the peak index


        int n = nums.length;
        int i = 0;
        int j = n-1;

        if( n < 3)
        {
            if(nums[i] > nums[j])
            {
                return i;
            }else{
                return j;
            }
        }

        while(i<=j)
        {
            int mid = (i + j)/2;

            if((mid == 0 && nums[mid] > nums[mid+1]) || (mid == n-1 && nums[mid] > nums[mid-1]) || ((mid<n-1 && mid>0) && nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]))
            {
                return mid;
            }

            if(nums[mid]<= nums[mid+1])
            {
                i = mid+1;
            }else{
                j = mid-1;
            }
        }

        return -1;
    }
}

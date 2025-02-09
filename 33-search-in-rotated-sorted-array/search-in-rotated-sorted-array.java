class Solution {
    public int search(int[] nums, int target) {

        int i = 0;
        int j= nums.length-1;

        int mid;

        while(i <= j )
        {
            mid = (i+j)/2;

            if(nums[mid] == target)
            {
                return mid;
            }


            if(nums[i] <= nums[mid])
            {
                if(target > nums[mid] || target < nums[i])
                {
                    i = mid+1;
                }else{
                    j = mid-1;
                }
            }else{
                if(target < nums[mid] || target > nums[j])
                {
                    j= mid-1;
                }else{
                    i = mid+1;
                }
            }
        }
        return -1;
        
    }
}

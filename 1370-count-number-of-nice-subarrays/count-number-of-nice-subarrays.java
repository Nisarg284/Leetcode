class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int count = 0;
        int totalCount = 0;
        int oddCount = 0;

        int i=0;
        int j =0;

        while(i < nums.length && j < nums.length)
        {
            if(nums[j] % 2 != 0)
            {
                oddCount++;
                count = 0;
            }

            while(i<=j && oddCount == k)
            {
                count++;
                if(nums[i] % 2 != 0)
                {
                    oddCount--;
                }
                i++;
            }

            totalCount+= count;
            j++;
        }

        return totalCount;
        
    }
}
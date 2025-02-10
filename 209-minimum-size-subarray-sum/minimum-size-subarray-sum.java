class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int length = Integer.MAX_VALUE;
        int sum = 0;

        int i = 0;
        int j = 0;

        while (i < nums.length && j < nums.length) {
            sum += nums[j];

            while (sum >= target) {
                length = Math.min(length,(j-i+1));
                sum -= nums[i];
                i++;
                
            }
            j++;

        }

        if(length == Integer.MAX_VALUE)
        {
            return 0;
        }

        return length;

    }
}
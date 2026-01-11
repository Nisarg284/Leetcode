class Solution {
    public boolean canJump(int[] nums) {


        int maxPoint = 0;
        int n = nums.length;

        for(int i = 0;i<n;i++)
        {
            if(i > maxPoint)
            {
                return false;
            }

            maxPoint = Math.max(maxPoint, i + nums[i]);
        }

        return true;
        
    }
}
class Solution {
    public int repeatedNTimes(int[] nums) {

        Set<Integer> hs = new HashSet<>();

        for(int i = 0;i<nums.length;i++)
        {
            if(hs.contains(nums[i]))
            {
                return nums[i];
            }

            hs.add(nums[i]);
        }
        return 0;
    }
}
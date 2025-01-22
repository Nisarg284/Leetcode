class Solution {
    public int missingNumber(int[] nums) {

        HashSet<Integer> hs = new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            hs.add(nums[i]);
        }

        int missing = 0;

        for(int i=0;i<=nums.length;i++)
        {
            if(!hs.contains(i))
            {
                missing = i;
                break;
            }
        }

        return missing;
        
    }
}
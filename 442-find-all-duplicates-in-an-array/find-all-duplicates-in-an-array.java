class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<nums.length;i++)
        {
            int idx = Math.abs(nums[i])-1;

            if(nums[idx] > 0)
            {
                nums[idx] = -nums[idx];
            }else{
                ans.add(Math.abs(nums[i]));
            }
        }
        
        return ans;
        
    }
}
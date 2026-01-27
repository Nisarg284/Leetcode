class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        Set<Integer> hs = new HashSet<>();

        for(int ele : nums)
        {
            hs.add(ele);
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 1;i<=nums.length;i++)
        {
            if(!hs.contains(i))
            {
                ans.add(i);
            }
        }

        return ans;
        
    }
}
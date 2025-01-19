class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }

        List<Integer>ans = new ArrayList<>();

        for(Integer i:hm.keySet())
        {
            if(hm.get(i)==2)
            {
                ans.add(i);
            }
        }

        return ans;
        
    }
}
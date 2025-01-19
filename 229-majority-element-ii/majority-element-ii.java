class Solution {
    public List<Integer> majorityElement(int[] nums) {

        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }

        int occure = nums.length/3;
        List<Integer> ans = new ArrayList<>();

        for(int i:hm.keySet())
        {
            if(hm.get(i)>occure)
            {
                ans.add(i);
            }
        }
        return ans;
        
    }
}
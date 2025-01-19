class Solution {
    public int majorityElement(int[] nums) {
        

      HashMap<Integer,Integer> hm = new HashMap<>();

      for(int i=0;i<nums.length;i++)
      {
        hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
      }


        int major = Integer.MIN_VALUE;
        int ele = nums[0];
      for(Integer i : hm.keySet())
      {
        if(hm.get(i)> major)
        {
            major = hm.get(i);
            ele = i;
        }
      }

      return ele;
        
    }
}
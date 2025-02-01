class Solution {
    public int singleNumber(int[] nums) {

       if(nums.length == 1)
       {
        return nums[0];
       }

       HashMap<Integer,Integer> hm = new HashMap<>();
       for(int i=0;i<nums.length;i++)
       {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
       }

       for(int i:hm.keySet())
       {
            if(hm.get(i) == 1)
            {
                return i;
            }
       }

       return 0;

       


        
    }
}
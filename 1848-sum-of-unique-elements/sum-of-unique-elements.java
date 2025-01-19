class Solution {
    public int sumOfUnique(int[] nums) {

        HashMap<Integer,Integer> hm = new HashMap<>();

        int sum = 0;

        for(int i=0;i<nums.length;i++)
        {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }

        for(Integer i:hm.keySet())
        {
            if(hm.get(i)<=1)
            {
                sum+=i;
            }
        }

        return sum;
        
    }
}
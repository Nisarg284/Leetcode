class Solution {
    public int thirdMax(int[] nums) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> hs = new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            if(!hs.contains(nums[i]))
            {
                pq.add(nums[i]);
                hs.add(nums[i]);
            }
            if(pq.size() > 3)
            {
                pq.remove();
            }
        }

        if(pq.size() < 3)
        {
            while(pq.size()!=1)
            {
                pq.remove();
            }
        }
        return pq.peek();
        
    }
}
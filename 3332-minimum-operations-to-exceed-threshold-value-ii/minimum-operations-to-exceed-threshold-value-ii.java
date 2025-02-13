class Solution {
    public int minOperations(int[] nums, int k) {

        // define Min heap
        PriorityQueue<Long> pq = new PriorityQueue<>();

        // put all array Elements in min heap
        for(int i=0;i<nums.length;i++)
        {
            pq.add((long)nums[i]);
        }

        int count = 0;

        while(pq.peek() < k && pq.size()>=2)
        {
            long firstMin = pq.remove();
            long secondMax = pq.remove();

            long nextEle = (firstMin * 2) + secondMax;
            pq.add(nextEle);
            count++; 
        }

        return count;
        
    }
}
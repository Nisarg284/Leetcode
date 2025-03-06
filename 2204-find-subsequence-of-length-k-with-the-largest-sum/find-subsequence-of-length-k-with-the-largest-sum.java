class Solution {

    class Pair{
        int val;
        int idx;

        public Pair(int val,int idx)
        {
            this.val = val;
            this.idx = idx;
        }
    }
    
    public int[] maxSubsequence(int[] nums, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)->p1.val - p2.val);

        for(int i=0;i<nums.length;i++)
        {
            pq.add(new Pair(nums[i],i));
            if(pq.size() > k)
            {
                pq.remove();
            }
        }

        PriorityQueue<Pair> pq1 = new PriorityQueue<>((p1,p2)->p1.idx - p2.idx);

        while(!pq.isEmpty())
        {
            pq1.add(pq.remove());
        }

        int[] ans = new int[k];
        int i=0;
        while(!pq1.isEmpty())
        {
            ans[i] = pq1.remove().val;
            i++;

        }

        return ans;
        
    }
}
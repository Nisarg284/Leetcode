class Solution {

    static class Pair{
        int val;
        int idx;

        public Pair(int val,int idx)
        {
            this.val = val;
            this.idx = idx;
        }
    }
    public int maxResult(int[] nums, int k) {
    PriorityQueue<Pair> pq = new PriorityQueue<>(
        (p1, p2) -> p2.val == p1.val ? p2.idx - p1.idx : p2.val - p1.val
    );

    pq.add(new Pair(nums[0], 0));
    int score = nums[0];

    for (int j = 1; j < nums.length; j++) {
        // Ensure the top of the heap is within the valid range
        while (!pq.isEmpty() && pq.peek().idx < j - k) {
            pq.poll();
        }

        score = pq.peek().val + nums[j];
        pq.add(new Pair(score, j));
    }

    return score;
        
    }
}
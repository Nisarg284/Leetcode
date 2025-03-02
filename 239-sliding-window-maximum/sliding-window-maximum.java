class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length-k+1];

        Deque<Integer> dq = new LinkedList<>();
        int l = 0;

        for(int i=0;i<nums.length;i++)
        {
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()] )
            {
                dq.removeLast();
            }

            dq.add(i);

            int j = i-k;
            while(j >= dq.peekFirst())
            {
                dq.removeFirst();
            }
            
            if(i>=k-1)
            {
                ans[l] = nums[dq.peekFirst()];
                l++;
            }
        }

        return ans;
        
    }
}
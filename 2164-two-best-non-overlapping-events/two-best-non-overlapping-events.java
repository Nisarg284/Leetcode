class Solution {
    public int maxTwoEvents(int[][] events) {

        int n = events.length;

        Arrays.sort(events,(a,b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        int ans = 0;
        int maxVal = 0;

        for(int [] event : events)
        {
            int start = event[0];
            int end = event[1];
            int value = event[2];

            while(!pq.isEmpty() && pq.peek()[1] < start)
            {
                maxVal = Math.max(maxVal,pq.remove()[2]);
            }

            pq.add(event);

            ans = Math.max(ans,maxVal + value);

        }

        return ans;
        
    }
}
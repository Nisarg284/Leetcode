class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;

        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for(int[]arr : intervals){
            pq.add(arr);
        }

        Stack<int[]> st = new Stack<>();
        st.add(pq.remove());

        int count = 0;

        while(!pq.isEmpty()){

            int[] prev = st.peek();
            int[] curr = pq.remove();

            if(prev[1] > curr[0]){
                count++;
            }else{
                st.add(curr);
            }
        }

        return count;

        
        
    }
}
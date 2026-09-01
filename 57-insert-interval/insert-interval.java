class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        pq.add(newInterval);
        for(int[]arr : intervals){
            pq.add(arr);
        }

        List<int[]>al = new ArrayList<>();
        al.add(pq.remove());

        while(!pq.isEmpty()){

            int[]prev = al.getLast();
            int[]curr = pq.remove();

            if(prev[1] >= curr[0]){

                if(prev[1] < curr[1]){
                    prev[1] = curr[1];
                }
            }else{
                al.add(curr);
            }
        }

        int[][]ans = new int[al.size()][2];

        int idx = 0;
        for(int[]arr : al){
            ans[idx++] = arr;
        }

        return ans;
        
    }
}
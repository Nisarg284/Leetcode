class Solution {
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for(int i = 0;i<n;i++){
            pq.add(intervals[i]);
        }

        ArrayList<int[]> al = new ArrayList<>();
        al.add(pq.remove());

        while(!pq.isEmpty()){

            int[]prev = al.getLast();
            int[]curr = pq.remove();

            if(prev[1] >= curr[0] ){
                if(prev[1] < curr[1]){
                    prev[1] = curr[1];
                }
            }else{
                al.add(curr);
            }
        }

        int[][] ans = new int[al.size()][2];
        int idx = 0;
        for(int[]arr : al){
            ans[idx] = arr;
            idx++;
        }

        // for(int i = 0;i<al.size();i++)
        // {
        //     ans[i][0] = al.get(i)[0];
        //     ans[i][1] = al.get(i)[1]; 
        // }

        return ans;
        
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length;

        ArrayList<int[]> al = new ArrayList<>();
        // al.add(intervals[0]);

        int i = 0;

        while(i < n && intervals[i][1]  < newInterval[0])
        {
            al.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1])
        {
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }

        al.add(newInterval);

        while( i < n)
        {
            al.add(intervals[i]);
            i++;
        }

        int[][] ans = new int[al.size()][2];

        for(i = 0;i<al.size();i++)
        {
            ans[i][0] = al.get(i)[0];
            ans[i][1] = al.get(i)[1];
        }
        

        return ans;
    }
}
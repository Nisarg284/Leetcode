class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        int n = intervals.length;

        Arrays.sort(intervals,(a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int lastEnd = intervals[0][1];
        int covered = 0;

        for(int i = 1;i<n;i++)
        {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            int prevStart = intervals[i-1][0];
            lastEnd = Math.max(intervals[i-1][1],lastEnd);


            if(currStart>= prevStart && currEnd <= lastEnd)
            {
                covered++;
            }

        }

        return n-covered;
        
    }
}
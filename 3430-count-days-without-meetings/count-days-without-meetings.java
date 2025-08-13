class Solution {
    public int countDays(int days, int[][] meetings) {

        Arrays.sort(meetings,(a,b) -> a[0] - b[0]);

        int n = meetings.length;

        int j = 1;
        int freeDays = 0;

        for(int i = 0;i<n;i++)
        {
            int start = meetings[i][0];
            int end = meetings[i][1];

            if(j > end)
            {
                continue;
            }

            if(j < start)
            {

                // System.out.println(" j : "+j+" , start : "+start+" , end : "+ end);
                freeDays += (start - j);
                j = end+1;
            }else{
                j = Math.max(j,end+1);
            }
        }

        // System.out.println(j);

        if(j <= days)
        {
            freeDays += (days - j)+1;
        }

        return freeDays;
        
    }
}
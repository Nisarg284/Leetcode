class Solution {
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points,(a,b) -> Integer.compare(a[1] ,b[1]));

        int n = points.length;

        int lastEnd = points[0][1];

        int arrows = 1;

        for(int i = 1;i<n;i++)
        {

            int start = points[i][0];
            int end = points[i][1];

            if(start > lastEnd)
            {
                lastEnd = end;
                arrows++;
            }
            // if(lastEnd >= start)
            // {
            //     continue;
            // }else{

            //     System.out.println("lastEnd : "+lastEnd);
            //     lastEnd = end;
            //     arrows++;
            // }
        }

        return arrows;
    }
}
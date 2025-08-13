class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int i = 0;
        int j = 0;

        ArrayList<int[]> al = new ArrayList<>();

        int m = firstList.length;
        int n = secondList.length;

        while(i < m && j < n)
        {
            int firstStart = firstList[i][0];
            int firstEnd = firstList[i][1];

            int secondStart = secondList[j][0];
            int secondEnd = secondList[j][1];

            if(firstEnd >= secondStart && firstStart<= secondEnd)
            {
                int[] miniAns = {Math.max(firstStart,secondStart),Math.min(firstEnd,secondEnd)};
                al.add(miniAns);
            }

            if(firstEnd <= secondEnd)
            {
                i++;
            }else{
                j++;
            }

        }

        int[][] ans = new int[al.size()][2];

        for(int k = 0;k<al.size();k++)
        {
            ans[k] = al.get(k);
        }

        return ans;
        
    }
}
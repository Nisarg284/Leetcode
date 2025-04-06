class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        int[] sort = score.clone();
        Arrays.sort(sort);
        HashMap<Integer,Integer> hm = new HashMap<>();
        String[] ans = new String[n];

        for(int i = 0;i<sort.length;i++)
        {
            hm.put(sort[i],n-1-i);
        }

        for(int i = 0;i<n;i++)
        {
            int rank = hm.get(score[i]);
            if(rank == 0)
            {
                ans[i] = "Gold Medal";
            }else if(rank == 1)
            {
                ans[i] = "Silver Medal";
            }else if(rank == 2)
            {
                ans[i] = "Bronze Medal";
            }else{
                ans[i] = rank+1+"";
            }
        }

        return ans;
        
    }
}
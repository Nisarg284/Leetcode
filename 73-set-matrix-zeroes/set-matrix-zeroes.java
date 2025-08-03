class Solution {
    public void setZeroes(int[][] arr) {


        int n = arr.length;
        int m = arr[0].length;

        HashMap<Integer,List<Integer>> hm = new HashMap<>();

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(arr[i][j] == 0)
                {
                    hm.computeIfAbsent(i,k -> new ArrayList<>()).add(j);
                }
            }
        }

        // System.out.println(hm);

        for(int i : hm.keySet())
        {

            for(int j = 0;j<m;j++)
            {
                arr[i][j] = 0;
            }
            List<Integer> cols = hm.get(i);
            for(int j = 0;j<cols.size();j++)
            {
                int currCol = cols.get(j);

                for(int k = 0;k<n;k++)
                {
                    arr[k][currCol] = 0;
                }
            }
        }


        
    }
}
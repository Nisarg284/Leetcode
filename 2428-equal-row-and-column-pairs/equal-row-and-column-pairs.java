class Solution {
    public int equalPairs(int[][] grid) {

        HashMap<ArrayList<Integer>,Integer> row = new HashMap<>();

        int n = grid.length;

        for(int i = 0;i<n;i++)
        {
            ArrayList<Integer> al = new ArrayList<>();
            for(int j = 0;j<n;j++)
            {
                al.add(grid[i][j]);
            }

            row.put(al,row.getOrDefault(al,0)+1);
        }



        int count = 0;
        for(int i = 0;i<n;i++)
        {
            ArrayList<Integer> al = new ArrayList<>();

            for(int j = 0;j<n;j++)
            {
                al.add(grid[j][i]);
            }

            if(row.containsKey(al))
            {
                count += row.get(al);
            }
        }

        return count;
        
    }
}





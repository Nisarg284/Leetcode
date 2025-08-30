class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        

        int n = grid.size();
        int m = grid.get(0).size();


        Queue<int[]> q = new LinkedList<>();
        int[][] minCost = new int[n][m];

        for(int[] arr : minCost)
        {
            Arrays.fill(arr,-1);
        }

        minCost[0][0] = health - grid.get(0).get(0);
        q.add(new int[]{0,0,minCost[0][0]});


        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};


        while(!q.isEmpty())
        {
            int[] curr = q.remove();
            int row = curr[0];
            int col = curr[1];
            int cost = curr[2];

            if(row == n-1 && col == m-1)
            {
                return true;
            }


            for(int[] d : dir)
            {
                int newRow = row + d[0];
                int newCol = col + d[1];

                if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m)
                {
                    int newCost = cost - grid.get(newRow).get(newCol);

                    if(newCost > 0 && newCost > minCost[newRow][newCol])
                    {
                        
                        q.add(new int[]{newRow,newCol,newCost});
                        minCost[newRow][newCol] = newCost;
                    }
                }
            }


        }

        return minCost[n-1][m-1] != -1;
    }
}
class Solution {
    public int shortestPath(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        if (k >= n + m - 2) {
            return n + m - 2;
        }

        Queue<int[]> q = new LinkedList<>();

        int[][] minCost = new int[n][m];

        for (int[] arr : minCost) {
            Arrays.fill(arr, -1);
        }
        

        // if(grid[0][0] == 1)
        // {
        //     minCost[0][0] = k-1;
        // }else{
        //     minCost[0][0] = k;
        // }

        minCost[0][0] = k;

        q.add(new int[]{0,0,0,minCost[0][0]});

        int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.remove();
                int row = curr[0];
                int col = curr[1];
                int steps = curr[2];
                int leftK = curr[3];

                if (row == n - 1 && col == m - 1) {
                    return steps;
                }

                for (int[] d : dir) {
                    int newRow = row + d[0];
                    int newCol = col + d[1];

                    if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m) {
                        int newK = leftK - grid[newRow][newCol];

                        if(newK >= 0 && newK > minCost[newRow][newCol])
                        {
                            q.add(new int[]{newRow,newCol,steps+1,newK});
                            minCost[newRow][newCol] = newK;
                        }
                    }
                }

            }
        }

        return -1;

    }
}
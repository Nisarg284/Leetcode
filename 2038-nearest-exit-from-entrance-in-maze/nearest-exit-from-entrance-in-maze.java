class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        

        int m = maze[0].length;
        int n = maze.length;

        int[] dir = new int[2];
        dir[0] = entrance[0];
        dir[1] = entrance[1];

        Queue<int[]> q = new LinkedList<>();

        boolean[][] vis = new boolean[n][m];

        int row = entrance[0];
        int col = entrance[1];
        vis[row][col] = true;
        q.add(dir);


        int minDist = 0;


        while (!q.isEmpty())
        {
            int size = q.size();
            // System.out.println(q.peek()[0] + " " + q.peek()[1]);

            for(int i = 0;i<size;i++) {


                int[] arr = q.remove().clone();

                int currRow = arr[0];
                int currCol = arr[1];

                // System.out.println("Row: "+currRow +" Col: "+currCol);

                if ((currRow == 0 || currCol == 0 || currRow == n - 1 || currCol == m - 1) && (currRow != entrance[0] || currCol != entrance[1])) {

                    return minDist;

                }
                
                    if( currRow > 0 && maze[currRow-1][currCol] == '.' && !vis[currRow - 1][currCol])
                    {
                        vis[currRow-1][currCol] = true;
                        q.add(new int[]{currRow-1,currCol});
                    }

                    if(currCol < m-1 && maze[currRow][currCol+1] == '.' && !vis[currRow ][currCol+1])
                    {
                        vis[currRow ][currCol+1] = true;
                        q.add(new int[]{currRow,currCol+1});
                    }

                    if(currRow < n-1 && maze[currRow+1][currCol] == '.' && !vis[currRow+1][currCol])
                    {
                        vis[currRow+1][currCol] = true;
                        q.add(new int[]{currRow+1,currCol});
                    }

                    if(currCol > 0 && maze[currRow][currCol-1] == '.' && !vis[currRow][currCol-1])
                    {
                        vis[currRow][currCol-1] = true;
                        q.add(new int[]{currRow,currCol-1});
                    }

            }
            minDist++;
        }

        return -1;
    }
}
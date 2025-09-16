class Solution {

    public static void fillAns(List<List<String>> ans, boolean[][] vis) {
        int n = vis.length;
        List<String> subAns = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (vis[i][j]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            subAns.add(sb.toString());
        }

        ans.add(subAns);
    }

    public static boolean isValid(int row, int col, boolean[][] vis) {
        int n = vis.length;
        // bottom
        for (int i = row + 1; i < n; i++) {
            if (vis[i][col]) {
                return false;
            }
        }

        // bottom left Diagonal
        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if (vis[i][j]) {
                return false;
            }
        }

        // bottom right Diagonal
        for (int i = row + 1, j = col + 1; i < n && j < n; i++, j++) {
            if (vis[i][j]) {
                return false;
            }
        }

        return true;
    }

    public static void nQueens( int n, List<List<String>> ans, boolean[][] vis) {
        // if(placedQueen == n)
        // {
        //     fillAns(ans,vis);
        //     return;
        // }

        // for(int i = 0;i<n;i++)
        // {

        // }

        if (n == 0) {
            fillAns(ans, vis);
            return;
        }
        for (int i = 0; i < vis.length; i++) {
            if (isValid(n - 1, i, vis)) {
                vis[n - 1][i] = true;
                nQueens(n - 1, ans, vis);
                vis[n - 1][i] = false;
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n == 1) {
            List<String> subAns = new ArrayList<>();
            subAns.add("Q");
            ans.add(subAns);
            return ans;
        }

        boolean[][] vis = new boolean[n][n];

        nQueens( n, ans, vis);

        return ans;

    }
}
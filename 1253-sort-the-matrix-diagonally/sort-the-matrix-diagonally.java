class Solution {
    public int[][] diagonalSort(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;


        HashMap<Integer,PriorityQueue<Integer>> hm = new HashMap<>();

        for(int i = 0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                hm.putIfAbsent(j-i,new PriorityQueue<>());
                hm.get(j-i).add(mat[i][j]);
            }
        }

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                mat[i][j] = hm.get(j-i).remove();
            }
        }

        return mat;

        

        
        
    }
}
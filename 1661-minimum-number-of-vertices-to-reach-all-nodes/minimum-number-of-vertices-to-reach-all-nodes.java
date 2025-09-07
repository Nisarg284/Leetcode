class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {


        int[] inDegree = new int[n];
        for(List<Integer>edge : edges)
        {
            int src = edge.get(0);
            int dest = edge.get(1);

            inDegree[dest]++;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            if(inDegree[i] == 0)
            {
                ans.add(i);
            }
        }

        return ans;
        
    }
}
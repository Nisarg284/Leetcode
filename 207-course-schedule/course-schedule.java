class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {


        Map<Integer,List<Integer>> graph = new HashMap<>();
        int[]inDegree = new int[numCourses];

        for(int[] node : prerequisites)
        {
            int src = node[0];
            int dest = node[1];

            inDegree[dest]++;
            graph.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<numCourses;i++)
        {
            if(inDegree[i] == 0)
            {
                q.add(i);
            }
        }



        int counter = 0;


        while(!q.isEmpty())
        {

            int size = q.size();

            for(int i = 0;i<size;i++)
            {
                counter++;
                int currVal = q.remove();
                List<Integer> neighbors = graph.get(currVal);

                if(neighbors != null)
                {
                    for(int neighbor : neighbors)
                    {
                        inDegree[neighbor]--;
                        if(inDegree[neighbor] == 0)
                        {
                            q.add(neighbor);
                        }
                    }
                }
            }

        }
        return counter == numCourses;  
    }
}
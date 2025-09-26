class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for(int[]pre : prerequisites)
        {
            int src = pre[1];
            int dest = pre[0];

            graph.computeIfAbsent(src,key -> new ArrayList<>()).add(dest);
            inDegree[dest]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<inDegree.length;i++)
        {
            if(inDegree[i] == 0)
            {
                q.add(i);
            }
        }

        int count = 0;
        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0;i<size;i++)
            {
                int src = q.remove();
                count++;

                List<Integer> dest = graph.get(src);
                if(dest == null)
                {
                    continue;
                }

                for(int d : dest)
                {
                    inDegree[d]--;
                    if(inDegree[d] == 0)
                    {
                        q.add(d);
                    }
                }
            }
        }
        return count == numCourses;
        
    }
}
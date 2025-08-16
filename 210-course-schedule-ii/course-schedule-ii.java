class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        HashMap<Integer,List<Integer>> graph = new HashMap<>();

        int[] inDegree = new int[numCourses];

        for(int[] pre : prerequisites)
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

        int idx = 0;
        int[] result = new int[numCourses];
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0;i<size;i++)
            {
                int src = q.remove();
                result[idx++] = src;

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

        return idx == numCourses ? result : new int[0];
        
    }
}
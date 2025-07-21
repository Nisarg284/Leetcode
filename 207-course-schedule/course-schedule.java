class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        int n = prerequisites.length;
        int m = numCourses;

        int[] indegree = new int[numCourses];

        // for(int i = 0;i<n;i++)
        // {
        //     for(int j = 0;j<m;j++)
        //     {
        //         int dest = i;
        //         int src = j;
                
        //         indegree[dest]++;
        //         graph.computeIfAbsent(src,k -> new ArrayList<>()).add(dest);
                
        //     }
        // }

        for(int[] i: prerequisites)
        {
            int dest = i[0];
            int src = i[1];

            indegree[dest]++;
            graph.computeIfAbsent(src,k -> new ArrayList<>()).add(dest);
        }

        System.out.println("Map: "+graph);

        Queue<Integer> q = new LinkedList<>();


        for(int i = 0;i<numCourses;i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }

        System.out.println("Queue: "+q);
        int count = 0;

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0;i<size;i++)
            {
                int src = q.remove();
                count++;

                ArrayList<Integer> destNodes = graph.get(src);
                if(destNodes == null)
                {
                    continue;
                }

                for(int dest : destNodes)
                {
                    indegree[dest]--;
                    if(indegree[dest] == 0)
                    {
                        q.add(dest);
                    }
                }
            }
        }
        return count == numCourses;   
    }
}
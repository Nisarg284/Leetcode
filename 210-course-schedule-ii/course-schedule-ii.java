class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {


        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];


        // Redefine Graph representation & count in-degree
        for(int[] i: prerequisites)
        {
            int src = i[1];
            int dest = i[0];

            inDegree[dest]++;
            graph.computeIfAbsent(src,k -> new ArrayList<>()).add(dest);
        }

        Queue<Integer> q = new LinkedList<>();

        // put all 0 in-degree vertices in queue
        for(int i = 0;i<inDegree.length;i++)
        {
            if(inDegree[i] == 0)
            {
                q.add(i);
            }
        }

        int[] seq = new int[numCourses];
        int idx = 0;


        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0;i<size;i++)
            {
                int src = q.remove();
                seq[idx++] = src;

                ArrayList<Integer> destNodes = graph.get(src);

                if(destNodes == null)
                {
                    continue;
                }

                for(int dest : destNodes)
                {
                    inDegree[dest]--;
                    if(inDegree[dest] == 0)
                    {
                        q.add(dest);
                    }
                }
            }
        }
        return idx == numCourses ? seq : new int[0];        
    }
}
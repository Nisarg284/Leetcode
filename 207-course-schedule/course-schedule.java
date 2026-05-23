class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        

        HashMap<Integer,List<Integer>> graph = new HashMap<>();

        int[]inDegree = new int[numCourses];

        for(int[]node : prerequisites){
            int src = node[0];
            int dest = node[1];



            graph.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);

            inDegree[dest]++;
        }


        Queue<Integer> q = new LinkedList<>();


        for(int i = 0;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0;i<size;i++){
                numCourses--;
                int curr = q.remove();
                List<Integer> destNodes = graph.get(curr);

                if(destNodes != null){
                    for(int dest : destNodes){
                        inDegree[dest]--;
                        if(inDegree[dest] == 0){
                            q.add(dest);
                        }
                    }
                }

            }
        }


        return numCourses == 0;
    }
}
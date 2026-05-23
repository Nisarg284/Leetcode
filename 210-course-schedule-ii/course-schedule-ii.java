class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {


        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        int[]inDegree = new int[numCourses];


        for(int[]node : prerequisites){
            int src = node[1];
            int dest = node[0];

            inDegree[dest]++;
            graph.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
        }

        Queue<Integer> q = new LinkedList<>();
        int[]order = new int[numCourses];

        for(int i = 0;i<numCourses;i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }



        int idx = 0;
        while(!q.isEmpty()){


            int size = q.size();

            for(int i = 0;i<size;i++){

                int curr = q.remove();
                order[idx] = curr;
                idx++;

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

        return idx == numCourses ? order : new int[0];
        
    }
}